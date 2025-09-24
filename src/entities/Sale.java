package entities;

public class Sale implements Comparable<Sale>{

    private Integer month;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale() {
    }

    public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
        this.month = month;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double avaragePrice(){
        return total / items;
    }

    @Override
    public String toString() {
        return month + "/" + year + ", " 
                + seller + ", " 
                + items + ", " 
                + String.format( "%.2f" , total) + ", pm = " 
                + String.format( "%.2f" , avaragePrice() ); 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((month == null) ? 0 : month.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        result = prime * result + ((seller == null) ? 0 : seller.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sale other = (Sale) obj;
        if (month == null) {
            if (other.month != null)
                return false;
        } else if (!month.equals(other.month))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        if (seller == null) {
            if (other.seller != null)
                return false;
        } else if (!seller.equals(other.seller))
            return false;
        return true;
    }

    @Override
    public int compareTo(Sale other) {
        return Double.compare( this.avaragePrice(), other.avaragePrice() );
    }
}
