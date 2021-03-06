package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
//import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SubmitScoreResource extends ServerResource {
	private static List<String> users = new ArrayList<String>();
	private String status;
	
    @Post
    public JsonRepresentation represent(Representation entity) throws IOException {
    	MuddyGame game = SingletonGameClass.getGameInstance();
    	System.out.println("entity:"+entity);
    	
    	JsonRepresentation represent = new JsonRepresentation(entity);
    	
    	JSONObject jsonobject = represent.getJsonObject();
    	
    	System.out.println("jsonobject.getString(username):"+jsonobject.getString("username"));
    	System.out.println("jsonobject.getString(score):"+jsonobject.getString("score"));
    	System.out.println("jsonobject.getString(time):"+jsonobject.getString("time"));
    	System.out.println("jsonobject.getString(isSolutionMST):"+jsonobject.getString("isSolutionMST"));
    	
    	int score = Integer.parseInt(jsonobject.getString("score"));
    	int time = Integer.parseInt(jsonobject.getString("time"));
    	//String sol=jsonobject.getString("isSolutionMST");
    	System.out.println("Int Score:"+score);
    	System.out.println("Int Score:"+time);
    	System.out.println("isSolutionMST:"+jsonobject.getString("isSolutionMST"));
    	
    	
    	if(game.getCurrentGameState().toString() == "Game Started State"){
    		game.submitPlayerOneScore(jsonobject.getString("username"), score,time,jsonobject.getString("isSolutionMST"));
    	}
    	else{
    		game.submitPlayerTwoScore(jsonobject.getString("username"), score,time,jsonobject.getString("isSolutionMST"));
    	}
    	users.add(jsonobject.getString("username"));
    	
    	
    	System.out.println("status:"+status);
    	JSONObject response = new JSONObject();
    	response.put("gameState", game.getCurrentGameState());
    	response.put("users",users); 
    	
        return (new JsonRepresentation(response));
    }

}
