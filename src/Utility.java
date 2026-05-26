public abstract class Utility {

        private int capacity;

        public Utility() {
            this.capacity = 100;
        }

        public int getCapacity() {
            return capacity;
        }

        public void resetCapacity() {
            capacity = 100;
        }

        public boolean hasCapacity() {
            return capacity > 0;
        }

        public int useCapacity(int requestedAmount) {
            int givenAmount = Math.min(requestedAmount, capacity);
            capacity -= givenAmount;
            return givenAmount;
        }

        public abstract String getUtilityType();
    }

