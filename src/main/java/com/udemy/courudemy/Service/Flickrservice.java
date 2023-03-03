package com.udemy.courudemy.Service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface Flickrservice {
    String savvePhoto(InputStream photo, String title) throws FlickrException;
}
