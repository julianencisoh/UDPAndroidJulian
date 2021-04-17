package com.example.udpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {


    private ImageView waffle;
    private ImageView festival;
    private ImageView payaso;
    private ImageView cono;
    private DatagramSocket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waffle = findViewById(R.id.waffle);
        festival = findViewById(R.id.festival);
        payaso = findViewById(R.id.payaso);
        cono = findViewById(R.id.cono);

        //creacion socket
        new Thread(() -> {

            try {
                socket = new DatagramSocket(5000);
                Log.e("-->","Esperando");

                // Recepcion del mensaje
                while (true) {
                    byte[] buff = new byte[256];
                    DatagramPacket packet = new DatagramPacket(buff, buff.length);

                    socket.receive(packet);
                    String recibido = new String(packet.getData()).trim();
                    Log.e("-->",recibido);

                    runOnUiThread(
                            ()->{
                                Toast.makeText(this, recibido, Toast.LENGTH_SHORT).show();
                            }
                    );
                }

            } catch (SocketException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ).start();

        //Envio
        waffle.setOnClickListener(
             v -> {
                 new Thread(
                         ()->{

                             try {
                                 //DatagramSocket socket = new DatagramSocket(5000);

                                 //Envio mensaje
                                 String mensaje = "waffle";
                                 DatagramPacket packet = new DatagramPacket(
                                         mensaje.getBytes(),
                                         mensaje.getBytes().length,
                                         InetAddress.getByName("10.0.2.2"),
                                         6000
                                 );
                                 socket.send(packet);
                             } catch (SocketException e) {
                                 e.printStackTrace();
                             } catch (UnknownHostException e) {
                                 e.printStackTrace();
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                         }
                 ).start();


             }
        );

        cono.setOnClickListener(
                v -> {
                    new Thread(
                            ()->{

                                try {
                                    //DatagramSocket socket = new DatagramSocket(5000);

                                    //Envio mensaje
                                    String mensaje = "cono";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);
                                } catch (SocketException e) {
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();


                }
        );

        festival.setOnClickListener(
                v -> {
                    new Thread(
                            ()->{

                                try {
                                    //DatagramSocket socket = new DatagramSocket(5000);

                                    //Envio mensaje
                                    String mensaje = "festival";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);
                                } catch (SocketException e) {
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();


                }
        );

        payaso.setOnClickListener(
                v -> {
                    new Thread(
                            ()->{

                                try {
                                    //DatagramSocket socket = new DatagramSocket(5000);

                                    //Envio mensaje
                                    String mensaje = "payaso";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);
                                } catch (SocketException e) {
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();


                }
        );

    }
}