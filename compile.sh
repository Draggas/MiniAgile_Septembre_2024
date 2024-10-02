#!/bin/bash

javac -d bin/ -cp lib/junit-platform-console-standalone-1.10.2.jar:lib/
jnativehook-2.2.2.jar src/main/java/*.java

echo "Compilation terminé"
