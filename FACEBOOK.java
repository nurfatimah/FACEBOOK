import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class FACEBOOK {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 *
 * @param args
 * @throws FacebookException
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("1546458525511892", "Aq2hrflRjzAmL8F_CJWIQqW_GPM");
    // Get an access token from:
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString = "EAAVZBfu8SsNQBAMsZCvDQL5IRlbJSdlt23M8lzNRBVSHzvI8eEZCTONNe7jlZBSCBRXWEfgxZBevmkANpA3zMnxK0ztokMpIVziXkTIwjfouiPOEqZA8PYGwlHX7ZBefAYSgfZBnq3bRWITZAqkPDVRcZCgjykd5I3Hp9yQXpWM8gZCFDorc3ZCAgR9GcfnZAZCZA1ZBYjdEWTaTQ0suXgZDZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("100034482111830",
            new Reading().limit(25));

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
        }
    }
}