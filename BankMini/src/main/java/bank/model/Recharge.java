package bank.model;

public class Recharge {
        private String mobNo;
        private String cust_id;
        private String Provider;
        private String recharge_type;
        private int billing_unit;
        private Double Price;
        
        public Recharge(String cust_id, String provider, Double price) {
            this.cust_id = cust_id;
            Provider = provider;
            Price = price;
        }
        public Recharge(String cust_id, String provider, String recharge_type, int billing_unit, Double price) {
            this.cust_id = cust_id;
            Provider = provider;
            this.recharge_type = recharge_type;
            this.billing_unit = billing_unit;
            Price = price;
        }
        public Recharge(String mobNo, String provider, String recharge_type, Double price) {
            this.mobNo = mobNo;
            Provider = provider;
            this.recharge_type = recharge_type;
            Price = price;
        }
        public String getMobNo() {
            return mobNo;
        }
        public Recharge(String mobNo, String cust_id, String provider, String recharge_type, int billing_unit,
				Double price) {
			super();
			this.mobNo = mobNo;
			this.cust_id = cust_id;
			Provider = provider;
			this.recharge_type = recharge_type;
			this.billing_unit = billing_unit;
			Price = price;
		}
		public void setMobNo(String mobNo) {
            this.mobNo = mobNo;
        }
        public String getProvider() {
            return Provider;
        }
        public void setProvider(String provider) {
            Provider = provider;
        }
        public String getRecharge_type() {
            return recharge_type;
        }
        public void setRecharge_type(String recharge_type) {
            this.recharge_type = recharge_type;
        }
        public Double getPrice() {
            return Price;
        }
        public void setPrice(Double price) {
            Price = price;
        }
        public String getCust_id() {
            return cust_id;
        }
        public void setCust_id(String cust_id) {
            this.cust_id = cust_id;
        }
        public int getBilling_unit() {
            return billing_unit;
        }
        public void setBilling_unit(int billing_unit) {
            this.billing_unit = billing_unit;
        }
}
