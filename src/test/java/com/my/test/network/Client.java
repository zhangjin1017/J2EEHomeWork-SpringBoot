package com.my.test.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String host = "localhost";
    private int port = 40000;
    private Socket socket;
    public Client() throws IOException {
        socket = new Socket(host, port);
        System.out.println(nowTime()+":开启客户端");
    }
    public PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketoutput = socket.getOutputStream();
        return new PrintWriter(socketoutput, true);
    }
    public BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketinput = socket.getInputStream();

        return new BufferedReader(new InputStreamReader(socketinput));
    }
    public void send() throws IOException {
        try {
                System.out.println(nowTime()+":请输入2个整数,以空格分隔");
                BufferedReader reader = this.getReader(socket);
                PrintWriter wirter = this.getWriter(socket);
                String msg = null;
                Scanner in = new Scanner(System.in);
                while (!(msg = in.nextLine()).equals(" ")) {
                    wirter.println(msg);
                    System.out.println(reader.readLine());
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    String nowTime(){
        //获取当前时间年月日时分秒
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
    public static void main(String[] args) throws IOException {
        new Client().send();
    }
}