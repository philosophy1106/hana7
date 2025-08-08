#!/bin/sh

# Gradle 데몬 중지
./gradlew --stop

# Gradle 캐시 디렉토리 완전 삭제
rm -rf ~/.gradle/caches/
rm -rf ~/.gradle/daemon/

# 프로젝트의 build 디렉토리도 삭제
rm -rf build/
rm -rf .gradle/

# 새로 빌드
./gradlew clean
./gradlew build