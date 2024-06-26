package fakeRestApiObjectModel.ActivitiesObjectModel;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ActivitiesRequest {

    private static final String baseUrl = System.getProperty("baseUrl");
    private static final String activitiesEndPoint = System.getProperty("activitiesEndPoint");
    SHAFT.API apiObject = new SHAFT.API(baseUrl);

    /**
     * @return Activities
     */
    public io.restassured.response.Response getAllActivities() {

        return apiObject.get(activitiesEndPoint).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
    }

    /**
     * @param requestBody set request body
     * @return Activity
     */
    public Response createActivity(JSONObject requestBody) {

        return apiObject.post(activitiesEndPoint).setContentType(ContentType.JSON).setRequestBody(requestBody).setTargetStatusCode(200).perform();
    }

    /**
     * @param id put specific id to get details
     * @return SingleActivity
     */
    public Response getSingleActivityByID(String id) {

        return apiObject.get(activitiesEndPoint + id).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
    }

    /**
     * @param id          put specific id to update activity
     * @param requestBody set request body
     * @return Activity
     */
    public Response updateActivity(String id, JSONObject requestBody) {

        return apiObject.put(activitiesEndPoint + id).setContentType(ContentType.JSON).setRequestBody(requestBody).setTargetStatusCode(200).perform();
    }

    /**
     * @param id put specific id to delete activity
     */
    public Response deleteActivity(String id) {

        return apiObject.delete(activitiesEndPoint + id).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
    }

}
