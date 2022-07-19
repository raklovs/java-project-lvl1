#include make-compose.mk
.DEFAULT_GOAL := build-run

run-dist:
	./app/build/install/app/bin/app.bat

install:
	./gradlew clean install

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain

update-deps:
	./gradlew useLatestVersions

build-run: build run

.PHONY: build

