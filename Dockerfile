FROM eclipse-temurin:17-jre-alpine
COPY /target/LottoExcelentJacekR.jar /LottoExcelentJacekR.jar
ENTRYPOINT ["java","-jar","/LottoExcelentJacekR.jar"]