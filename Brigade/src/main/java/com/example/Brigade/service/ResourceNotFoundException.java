package com.example.Brigade.service;

import javax.transaction.xa.XAException;

public class ResourceNotFoundException extends XAException {
    public ResourceNotFoundException(String userApp, String id, Integer id1) {
    }
}
