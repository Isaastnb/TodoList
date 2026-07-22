#!/bin/bash

# Compila os arquivos mais recentes da pasta src para a pasta bin
# e em seguida executa o aplicativo
javac -d bin -cp "lib/*" -sourcepath src src/app/App.java && java -cp "lib/*:bin" app.App
