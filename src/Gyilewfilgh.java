import java.util.ArrayList;

public class Gyilewfilgh {
    public static class BTNode {

        public static final int PARSE_IN = 1;

        public static final int PARSE_PRE = 2;

        public static final int PARSE_POST = 3;

        String name;

        BTNode lPointer,rPointer;

        public BTNode(String s) {

            name = s;

            lPointer = rPointer = null;

        }

        public void insert(String s) {

            insert(this,s);

        }

        private static void insert(BTNode node,String s) {

            int comparison = s.compareTo(node.name);

            if(comparison < 0) {

                if(node.lPointer != null) {

                    insert(node.lPointer,s);

                } else {

                    node.lPointer = new BTNode(s);

                }

            } else if(comparison > 0) {

                if(node.rPointer != null) {

                    insert(node.rPointer,s);

                } else {

                    node.rPointer = new BTNode(s);

                }

            }

        }



        public ArrayList<String> parse(final int parseOrder) {

            return parse(this,parseOrder);

        }

        private static ArrayList<String> parse(BTNode node, final int parseOrder) {

            ArrayList<String> retVal = new ArrayList<String>();

            if(node == null) {

                return(retVal);

            }

            ArrayList<String> leftList = parse(node.lPointer,parseOrder);

            ArrayList<String> rightList = parse(node.rPointer,parseOrder);

            if(parseOrder == PARSE_PRE) {

                retVal.add(node.name);

                retVal.addAll(leftList);

                retVal.addAll(rightList);

            } else if (parseOrder == PARSE_POST) {

                retVal.addAll(leftList);

                retVal.addAll(rightList);

                retVal.add(node.name);

            } else {

                retVal.addAll(leftList);

                retVal.add(node.name);

                retVal.addAll(rightList);

            }

            return retVal;

        }

    }

    public static void main(String[] args) {

        String[] names = {"Thomas Aquinas","Thomas Cajetan","Thomas Prufer","Thomas the Tank Engine","Thomas the Bread-Eater"};

        BTNode node = new BTNode(names[0]);

        for(int i = 1; i < names.length; i++) {

            node.insert(names[i]);

        }

        ArrayList<String> traversedNames = node.parse(BTNode.PARSE_POST);

        for(String s : traversedNames) {

            System.out.println(s);

        }

    }
}
