public class OctaveClassifier{
	public int[] classify(String[] trainingData, String[] testData){
		int arr[]=new int[testData.length];	
      String Data[];
      double count1,count2;
      count1=count2=0;
      double TotalX1,TotalX2,TotalY1,TotalY2;
      double dist1,dist2,temp1,temp2,dist3;
      double MeanX1,MeanX2,MeanY1,MeanY2;
      double ratio;
      TotalX1=TotalX2=TotalY1=TotalY2=0;
        for(int i=0;i<trainingData.length;i++){
          Data=trainingData[i].split(",");
          if(Data[5].equals("FM")){
            TotalX1+=Double.parseDouble(Data[2]);
            TotalY1+=Double.parseDouble(Data[3]);
          	count1++;
          }
          else if(Data[5].equals("TT")){
          	TotalX2+=Double.parseDouble(Data[2]);
            TotalY2+=Double.parseDouble(Data[3]);
          	count2++;
          }
        }
      MeanX1=TotalX1/count1;
      MeanX2=TotalX2/count2;
      MeanY1=TotalY1/count1;
      MeanY2=TotalY2/count2;
      for(int i=0;i<testData.length;i++){
        Data=testData[i].split(",");
        temp1=Double.parseDouble(Data[2]);
        temp2=Double.parseDouble(Data[3]);
      	dist1=Math.pow((MeanX1-temp1),2)+Math.pow((MeanY1-temp2),2);
        dist2=Math.pow((MeanX2-temp1),2)+Math.pow((MeanY2-temp2),2);
        dist3=Math.pow((temp1),2)+Math.pow((temp2),2);
        ratio=dist1/dist2;
        if(ratio<0.6){
        	arr[i]=1;
        }
        else if(ratio>1.4){
        	arr[i]=2;
        }
        else{
        	ratio=dist3*dist3/(dist1*dist2);
          if(ratio<0.5){
          	arr[i]=4;
          }
          else{
          	arr[i]=3;
          }
        }
      }
      	return arr;
	}
}
