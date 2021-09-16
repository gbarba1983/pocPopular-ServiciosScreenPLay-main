#!/bin/bash

# Copia el war

cp -rf target/ pipeline/report/

echo "########################################################"
echo "*** (BUILD)Enviando  Reporte serenity TrainingSiteJSP***"
echo "########################################################"

cd pipeline/report/ && docker-compose -f docker-compose-build.yml up -d