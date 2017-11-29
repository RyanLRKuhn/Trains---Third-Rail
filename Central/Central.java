import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Central{
	private TrackModel trackModel;
	private Wayside wayside;
	private CTCcontroller ctc;
	private CentralGui centralGui;
	private boolean hasTrainModel=false;
	private String[] args;
	public static void main(String[] args){
		Central thisCentral = new Central(args);
	}
	public Central(String[] Args){
		centralGui = new CentralGui(Args,this);
		args=Args;
	}
	public void TestMethod(String testString){
		System.out.println(testString);
	}

	public void CreateTrackModel(String[] emptyArgs){
		System.out.println("Create Track Model");
		trackModel=new TrackModel(emptyArgs, this);
	}
	public void CreateCTC(String[] emptyArgs){
		System.out.println("Create CTC");
		ctc=new CTCcontroller();
	}

	public void CreateTrain(int trainNum, int length, int direction,int startBlock){
		if(hasTrainModel) {
			trackModel.NewTrainTrain(trainNum, length, direction, startBlock);
		}else{
			trackModel.NewTrainTrain(trainNum, length, direction, startBlock,true);
		}
	}
	public void UpdateTrack(HashMap<String,HashMap<String,ArrayList<Block>>> track){
		System.out.println("Updating the track");
		ctc.receiveTrackData(track);
		wayside=new Wayside(args, this, track);
	}
	public void UpdateTrainDistance(int trainId, float  movedDistance){

	}
	public void Update(){

	}
	/*
	public void suggestedSpeed(int blockForTrain, double speedForTrain){
		XXXX.receiveSpeed(blockForTrain, speedForTrain);
	}
	public void suggestedAuthority(int blockForTrain, int blockForAuthority){
		XXXX.receiveAuthority(blockForTrain, blockForAuthority);
	}
	public void switchSignalWayside(int blockWithSwitch){
		XXXX.signalSwitchChange(blockWithSwitch);
	}
	public void updateSales(int numOfTickets){
		CTC.receiveTickets(numOfTickets);
	}
	public void updateBlocks(ArrayList<int> updatedBlocks){
		Tracking.update(updatedBlocks);
	}
	public void sendTrack(HashMap<String,HashMap<String,ArrayList<Block>>> track){
		Tracking.receiveTrackData(track);
		XXXX.receiveTrackData(track);
	}
	*/
	
}