FROM eclipse-temurin:17-jre-alpine
EXPOSE 8001
COPY /target/LottoExcelentJacekR.jar /LottoExcelentJacekR.jar
ENTRYPOINT ["java","-jar","/LottoExcelentJacekR.jar"]