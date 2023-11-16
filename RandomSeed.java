import java.util.Random;


class RandomSeed {
    Random rnd = new Random();
    
    
    public RandomSeed(long seed){
        rnd.setSeed(seed);
    }
    
    public int getSeed(){
        return rnd.nextInt(5);
    }
}