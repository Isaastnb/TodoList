#!/bin/bash

set -e

mvn compile exec:java -Dexec.mainClass="app.App"
