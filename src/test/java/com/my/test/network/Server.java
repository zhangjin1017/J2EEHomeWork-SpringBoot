package com.my.test.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port = 40000;
    private ServerSocket serverSocket;
    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(nowTime()+":服务端已启动");
    }
    public PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketoutput = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(socketoutput,true);
        return printWriter;
    }
    public BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketinput = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketinput));

        return bufferedReader;
    }
    public void server()
    {
        while(true)
        {
            Socket socket = null;
            try {
                socket = serverSocket.accept();//等待客户连接
                System.out.println(nowTime()+":已有客户端连接，地址："+socket.getInetAddress()+" 端口号："+socket.getPort());
                PrintWriter writer = this.getWriter(socket);
                BufferedReader reader = this.getReader(socket);
                String msg = null;
                int num1=0,num2=0;
                while ((msg = reader.readLine())!=null)
                {
                    System.out.println(nowTime()+":"+socket.getInetAddress()+" "+socket.getPort()+" 发来了2个整数："+msg);
                    String[] str = msg.split(" ");
                    num1= Integer.parseInt(str[0]);
                    num2= Integer.parseInt(str[1]);
                    writer.println(nowTime()+":server收到了："
                            +num1+"+"+num2+"="+(num1+num2)+",  "
                            +num1+"-"+num2+"="+(num1-num2)+",  "
                            +num1+"*"+num2+"="+(num1*num2)+",  "
                            +num1+"/"+num2+"="+(num1/num2)
                    );

                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(socket!=null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    String nowTime(){
        //获取当前时间年月日时分秒
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
    public static void main(String[] args) throws IOException {
        new Server().server();
    }
}