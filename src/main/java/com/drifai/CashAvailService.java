package com.drifai;


import java.util.ArrayList;
import java.util.List;

import com.drifai.dto.CashAvailable;
import com.drifai.grpc.Cashavail.APIResponse;
import com.drifai.grpc.Cashavail.CashAvailRequest;
import com.drifai.grpc.cashAvailGrpc.cashAvailImplBase;


import io.grpc.stub.StreamObserver;

public class CashAvailService extends cashAvailImplBase {

	@Override
	public void getCashAvail(CashAvailRequest request, StreamObserver<APIResponse> responseObserver) {
		
//		String fundId = request.getFundId();
//		String currency = request.getCurrency();
//		String cashAvailType = request.getCashAvailType();
//		String cashAvailSubType = request.getCashAvailSubType();
		
		System.out.println("\nRequest coming in: " + request.toString());
		
		CashAvailable fakedData = getFakedData();
		APIResponse response =
			APIResponse.newBuilder()
			.setClientId(fakedData.getClientId())
			.setFundId(fakedData.getFundId())
			.setCashAvailType(fakedData.getCashAvailType())
			.setCashAvailSubType(fakedData.getCashAvailSubtype())
			.setKnowledgeDate(fakedData.getKnowledgeDate())
			.setEffectiveDate(fakedData.getEffectiveDate())
			.setCurrency(fakedData.getCurrency())
			.setAmount(fakedData.getAmount())
			.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getCashAvailStream(CashAvailRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("\nRequest coming in: " + request.toString());
		
		
		//try {
			List<CashAvailable> fakedData = getMultipleFakedData();

		    for (CashAvailable cash : fakedData) {
		    	APIResponse response =
		    			APIResponse.newBuilder()
		    			.setClientId(cash.getClientId())
		    			.setFundId(cash.getFundId())
		    			.setCashAvailType(cash.getCashAvailType())
		    			.setCashAvailSubType(cash.getCashAvailSubtype())
		    			.setKnowledgeDate(cash.getKnowledgeDate())
		    			.setEffectiveDate(cash.getEffectiveDate())
		    			.setCurrency(cash.getCurrency())
		    			.setAmount(cash.getAmount())
		    			.build();
		    	responseObserver.onNext(response);
		    }
		  //} catch (RuntimeException e) {
		    // Cancel RPC
		  //  requestObserver.onError(e);
		  //  throw e;
		  //}
		
		
		
		responseObserver.onCompleted();
	}
	

	
	private CashAvailable getFakedData() {
		return new CashAvailable("12345", "3C", "CapStock", "CPSTKCLR", "2020-09-06", "2020-09-06", "EUR", -3500.00);
	}
	
	private List<CashAvailable> getMultipleFakedData() {
		List<CashAvailable> list = new ArrayList<>();
		list.add(new CashAvailable("12345", "3C", "CapStock", "CPSTKCLR", "2020-09-06", "2020-09-06", "EUR", -3500.00));
		list.add(new CashAvailable("12345", "3C", "CapStock", "CPSTKCLR", "2020-09-06", "2020-09-06", "EUR", -2500.00));
		return list;
	}
	
	

	
	

}

