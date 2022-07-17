include make-compose.mk

console:
	php artisan tinker

deploy:
	git push heroku main

setup: env-prepare sqlite-prepare install key db-prepare ide-helper
	npm run development

install-app:
	composer install

install-frontend:
	npm ci

install: install-app install-frontend

start:
	heroku local -f Procfile.dev

start-app:
	php artisan serve --host 0.0.0.0 --port 8000

start-frontend:
	npm run watch

db-prepare:
	php artisan migrate:fresh --seed

lint: lint-js lint-php

lint-fix:
	composer exec phpcbf -v

test:
	php artisan test

test-coverage:
	XDEBUG_MODE=coverage php artisan test --coverage-clover build/logs/clover.xml

analyse:
	composer exec phpstan analyse -v -- --memory-limit=1G

check: lint analyse test

config-clear:
	php artisan config:clear

env-prepare:
	cp -n .env.example .env || true

sqlite-prepare:
	touch database/database.sqlite

key:
	php artisan key:generate

ide-helper:
	php artisan ide-helper:eloquent
	php artisan ide-helper:gen
	php artisan ide-helper:meta
	php artisan ide-helper:mod -n

lint-js:
	npm run lint-js

lint-php:
	composer exec phpcs -v

lint-js-fix:
	npm run lint-js-fix

setup-git-hooks:
	npx simple-git-hooks

.PHONY: test

pre-push-hook: lint

S := web
VERSION := latest
PROJECT := hexlet-basics

include make-compose.mk
include make-services-web.mk
include make-services-caddy.mk
include k8s/Makefile

project-setup: project-files-touch project-env-generate compose-setup
	npm install
	git clone git://github.com/inishchith/autoenv.git ~/.autoenv || true
	grep -qxF 'source ~/.autoenv/activate.sh' ~/.bash_profile || echo 'source ~/.autoenv/activate.sh' >> ~/.bash_profile
	grep -qxF 'export AUTOENV_ENV_FILENAME=.autoenv' ~/.bash_profile || echo 'export AUTOENV_ENV_FILENAME=.autoenv' >> ~/.bash_profile
	grep -qxF 'export AUTOENV_ENV_LEAVE_FILENAME=.autoenv.leave' ~/.bash_profile || echo 'export AUTOENV_ENV_LEAVE_FILENAME=.autoenv.leave' >> ~/.bash_profile
	grep -qxF 'export AUTOENV_ENABLE_LEAVE=true' ~/.bash_profile || echo 'export AUTOENV_ENABLE_LEAVE=true' >> ~/.bash_profile
	export AUTOENV_ENV_FILENAME=.autoenv
	mkdir .kube

cluster-setup:
	doctl auth init
	doctl kubernetes cluster kubeconfig save hexlet-basics-3
	kubectx do-fra1-hexlet-basics-3

project-files-touch:
	mkdir -p tmp
	if [ ! -f tmp/ansible-vault-password ]; then echo 'jopa' > tmp/ansible-vault-password; fi;

project-env-generate:
	docker run --rm -e RUNNER_PLAYBOOK=ansible/development.yml \
		-v $(CURDIR)/ansible/development:/runner/inventory \
		-v $(CURDIR):/runner/project \
		ansible/ansible-runner

terraform-vars-generate:
	docker run --rm -e RUNNER_PLAYBOOK=ansible/terraform.yml \
		-v $(CURDIR)/ansible/production:/runner/inventory \
		-v $(CURDIR):/runner/project \
		ansible/ansible-runner

ansible-vaults-edit:
	# docker run -it -v $(CURDIR):/web -w /web ansible ansible-vault edit ansible/production/group_vars/all/vault.yml --vault-password-file=tmp/ansible-vault-password
	docker run -it --rm \
		-v $(CURDIR):/runner/project \
		ansible/ansible-runner ansible-vault edit project/ansible/production/group_vars/all/vault.yml
tag:
	git tag $(TAG) && git push --tags