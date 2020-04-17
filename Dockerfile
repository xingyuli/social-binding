FROM oracle/graalvm-ce:20.0.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/social-binding
WORKDIR /home/app/social-binding

RUN native-image --no-server -cp build/libs/social-binding-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/social-binding/social-binding /app/social-binding
ENTRYPOINT ["/app/social-binding"]
