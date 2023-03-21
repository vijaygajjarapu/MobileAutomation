//package com.iehp.utilities;
//
//
//public class RestAPIOperations {
//    public static RestAPIOperations singleInstance = null;
//
//    public static RestAPIOperations getInstance() {
//        if (singleInstance == null) {
//            singleInstance = new RestAPIOperations();
//        }
//        return singleInstance;
//    }
//
//    public ValidatableResponse postAPI(
//            String url, String reqData, String header, String headerValue) {
//        RestAssured.baseURI = url;
//
//        given()
//                .header(header, headerValue)
//                .when()
//                .post(reqData)
//                .then()
//                .log()
//                .ifError()
//                .assertThat()
//                .statusCode(200);
//        ValidatableResponse responseMsg =
//                given().header(header, headerValue).when().post(reqData).then().log().body();
//        return responseMsg;
//    }
//
//    public String getAPIUrl(String url) {
//        RequestSpecification request = RestAssured.given();
//
//        RestAssured.baseURI = url;
//        return url;
//    }
//}