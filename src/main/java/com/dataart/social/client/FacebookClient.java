package com.dataart.social.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;

/**
 * Created by vkapustin on 02.10.15.
 */
@Component
public class FacebookClient {

    @Autowired
    private Facebook facebook;
}
