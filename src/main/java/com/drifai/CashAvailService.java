package com.drifai;


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
	
	private CashAvailable getFakedData() {
		return new CashAvailable("12345", "3C", "CapStock", "CPSTKCLR", "2020-09-06", "2020-09-06", "EUR", -3500.00);
	}
	
	

	
	

}

