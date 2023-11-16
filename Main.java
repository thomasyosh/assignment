import java.util.*;
//觀自在菩薩
class Main{
    
    public static void main(String[] args) {
        //行深般若波羅蜜多時
        Scanner scanner = new Scanner(System.in);
        //照見五蘊皆空
        RandomSeed random = null;
        //度一切苦厄
        Queue queue = new LinkedQueue();
        
        //舍利子 色不異空 空不異色
        System.out.print("Input simulation time (mins):");

        //色即是空 空即是色
        int minutes = scanner.nextInt();
        //受想行識 亦復如是
        int actionQueued = 0;
        //舍利子 是諸法空相
        int numberOfMembersServed = 0;
        //不生不滅 不垢不淨 不增不減
        boolean randomInput = false;
        

        //是故空中無色
        if (minutes == 0 ){
        //無受想行識 無眼耳鼻舌身意 無聲色香味觸法
            randomInput = true;
        //無眼界 乃至無意識界
            minutes = 10;
        //無無明 亦無無明盡
            System.out.print("Input seed number: ");
            long seed = scanner.nextLong();
            random = new RandomSeed(seed);
            
        }

        System.out.println("---------------- START OF SIMULATION -----------------");

        for (int i=0;i<minutes;i++){
            int action = -1;
            
            while (action !=0){
                System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
                if (randomInput){
                    action = random.getSeed();
                    System.out.println(action);
                }

                else
                    action = scanner.nextInt();

                switch (action){
                    case 1:
                        queue.enqueue(new Action(4, "new member"));
                        actionQueued++;
                        break;
                    case 2:
                        queue.enqueue(new Action(2, "gift"));
                        actionQueued++;
                        break;
                    case 3:
                        queue.enqueue(new Action(1, "check bal"));
                        actionQueued++;
                        break;
                    case 4:
                        queue.enqueue(new Action(3, "trans bal"));
                        actionQueued++;
                        break;
                }
            }
            
            if (!queue.isEmpty()){
                Action front = (Action) queue.front();
                if(front.minutes != 1)
                    front.edit(front.minutes - 1);
                else{
                    queue.dequeue();
                    numberOfMembersServed++;
            }
            }
            
            
            System.out.println("After "+ (i+1) +" min(s):"+queue);
            System.out.println("------------------------------------------------------");
        }

            System.out.println("----------------- END OF SIMULATION ------------------");
            System.out.println("Total mins simulated: "+minutes + " minutes");
            System.out.println("Number of members served: "+numberOfMembersServed);
            System.out.println("Action queued during the simulation: "+actionQueued);
            System.out.println("Outstanding item at the end of simulation: "+ (actionQueued - numberOfMembersServed));
    }
}