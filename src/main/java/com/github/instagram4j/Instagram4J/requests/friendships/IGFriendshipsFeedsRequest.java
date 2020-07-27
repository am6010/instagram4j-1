package com.github.instagram4j.Instagram4J.requests.friendships;

import com.github.instagram4j.Instagram4J.IGClient;
import com.github.instagram4j.Instagram4J.requests.IGGetRequest;
import com.github.instagram4j.Instagram4J.responses.feed.IGUsersFeedResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class IGFriendshipsFeedsRequest extends IGGetRequest<IGUsersFeedResponse> {
    @NonNull
    private Long _id;
    @NonNull
    private IGFriendshipsFeeds action;
    private String _max_id;
    
    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", _max_id);
    }
    
    @Override
    public String path() {
        return String.format("friendships/%s/%s/", _id, action.name().toLowerCase());
    }
    @Override
    public Class<IGUsersFeedResponse> getResponseType() {
        return IGUsersFeedResponse.class;
    }
    
    public static enum IGFriendshipsFeeds {
        FOLLOWERS, FOLLOWING;
    }
}