package com.dataart.social;

import com.dataart.social.configuration.SocialConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vkapustin on 02.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SocialConfig.class })
public class FacebookClientTest {

    @Autowired
    private Facebook facebook;

    @Test
    public void testBaseFunctionality() {
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        for (Post post : feed) {
            System.out.println(post.getCaption());
        }
    }
}
