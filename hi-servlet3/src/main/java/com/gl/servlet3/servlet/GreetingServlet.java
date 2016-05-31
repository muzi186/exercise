package com.gl.servlet3.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by gavin on 16-6-1.
 */
@WebServlet(urlPatterns="/greeting")
public class GreetingServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(GreetingServlet.class);
    private AtomicLong count = new AtomicLong();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGet {} at {}", count.incrementAndGet(), new Date().toString());

        PrintWriter pw = new PrintWriter(resp.getOutputStream());

        pw.print("Hi, this is servlet 3 demo.");
        pw.flush();
        pw.close();
    }
}
