import java.io.File 


class IrisFlower {
   private int DatasetOrder;
   private double SepalLength;
   private double SepalWidth;
   private double PetalLength;
   private double PetalWidth;
   private String Species;
	
// constructor
    public IrisFlower(int DatasetOrder, double SepalLength,double SepalWidth,double PetalLength,double PetalWidth,String Species) {
        this.DatasetOrder = DatasetOrder;
        this.SepalLength = SepalLength;
        this.SepalWidth = SepalWidth;
        this.PetalLength = PetalLength;
        this.PetalWidth = PetalWidth;
        this.Species = Species
    }


   void setDatasetOrder(int dID) {
      DatasetOrder = dID;
   }
	
   void setSepalLength(double SepalL) {
      SepalLength = SepalL;
   }
   void setSepalWidth(double SepalW) {
      SepalWidth = SepalW;
   }

   void setPetalLength(double PetalL) {
      PetalLength = PetalL;
   }
   void setPetalWidth(double PetalW) {
      PetalWidth = PetalW;
   }
   void setSpecies(String Sp) {
      Species = Sp;
   }
   int getDatasetOrder() {
      return this.DatasetOrder;
   }
   double getSepalLength() {
      return this.SepalLength;
   }
   double getSepalWidth() {
      return this.SepalWidth;
   }     
   
   double getPetalLength() {
      return this.PetalLength;
   }
   double getPetalWidth() {
      return this.PetalWidth;
   }
   String getSpecies() {
      return this.Species;
   }

   static void main(String[] args) {
      //IrisFlower irisObj[]
      //def irisOb = []
      List<IrisFlower> irisObj = []
      List<IrisFlower> setosaObj = []

      IrisFlower iris1 = new IrisFlower(0,0,0,0,0,"null");
      iris1.setDatasetOrder(1);
      iris1.setSepalLength(1.1);	
      println(iris1.getDatasetOrder());
      println(iris1.getSepalLength());


def file = new File("irisdataset.csv")
def rows = file.readLines().tail()*.split(',')
int total = rows.size()

rows.each{line ->
        //println(line)
        //print(line.getAt(0));
        //println(line.getAt(5));
irisObj.add( new IrisFlower(line.getAt(0).toInteger(), Double.parseDouble(line.getAt(1)),Double.parseDouble(line.getAt(2)),Double.parseDouble(line.getAt(3)),Double.parseDouble(line.getAt(4)),line.getAt(5)));

}


// using lists
Set Species = rows*.getAt(5)
Set PetalLength = rows*.getAt(3)
Set PetalWidth = rows*.getAt(4)

String result = "number of rows $total number of species ${Species.size()}  " +
        "${PetalLength.size()} petal length and ${PetalWidth.size()} petal widith ."
println (result)
    def setosa = rows.findAll {it[5] == "I. setosa"}
   // println(setosa);
    println(setosa.size());
    
//using a class list

for (flower in irisObj) {
    println "Name: $flower.Species , length  $flower.DatasetOrder"
    //println "Name: $flower"

    if (flower.Species == "I. setosa") {
        setosaObj.add(flower) 

    }
}

println(irisObj.size());
println(setosaObj.size());


}