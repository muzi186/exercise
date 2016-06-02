package com.gl.securitytutorial.methodsecurity.service;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by gavin on 16-6-2.
 */
public class AccountService {
    private List<String> accounts = new ArrayList<>();

    private ReadWriteLock accountsLock = new ReentrantReadWriteLock();
    private Lock readLock = accountsLock.readLock();
    private Lock writeLock = accountsLock.writeLock();

    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<String> getAccounts(){
        readLock.lock();
        try{
            return Collections.unmodifiableList(this.accounts);
        }finally{
            readLock.unlock();
        }

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public boolean addAccount(String account){
        writeLock.lock();
        try {
            if (this.accounts.contains(account)) {
                return false;
            }

            return accounts.add(account);
        }finally{
            writeLock.unlock();
        }
    }

    @PreAuthorize("hasAuthority('ROLE_SUPERVISOR')")
    public boolean removeAccount(String account){
        writeLock.lock();
        try {
            if (!accounts.contains(account)) {
                return false;
            }

            return accounts.remove(account);
        }finally{
            writeLock.unlock();
        }
    }
}
