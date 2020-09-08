
package com.drifai;

import java.io.IOException;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Server server = ServerBuilder.forPort(9090).addService(new CashAvailService()).build();
		
		server.start();
		
		System.out.println("CashAvailability GRPC Server started at " + server.getPort());
		
		server.awaitTermination();
		
	}

}
