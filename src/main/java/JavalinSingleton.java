

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
            
            //implement logic here
            Song song = ctx.bodyAsClass(Song.class);
            String songJson = om.writeValueAsString(song);
            ctx.result(songJson);
                
        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            //create a lambda instance of the song class convert the bodyAsClass as a javalin context 
            Song song = ctx.bodyAsClass(Song.class);
            // set the song interface's artist name to "Beatles"
            song.setArtistName("Beatles");
            // Utilize Jacksons Object Mapper to write the song object as a json string
            String songJson = om.writeValueAsString(song);
            ctx.result(songJson);
        });


        return app;
    }
    
}
