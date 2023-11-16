import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedQueue();
        System.out.print("Input simulation time (mins):");
        int minutes = scanner.nextInt();
        int actionQueued = 0;
        int numberOfMembersServed = 0;

        System.out.println("---------------- START OF SIMULATION -----------------");

        for (int i=0;i<minutes;i++){
            int action = -1;
            while (action !=0){
                System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
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
            Action front = (Action) queue.front();
            if (front.minutes != 1){
                front.edit(front.minutes - 1);
            }
            else{
                queue.dequeue();
                numberOfMembersServed++;
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