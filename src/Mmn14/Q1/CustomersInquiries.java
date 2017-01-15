package Mmn14.Q1;


public class CustomersInquiries {
    private String _customerName;
    private String _id;
    private String _details;


    public CustomersInquiries(String _customerName, String _id, String _details) {
        this._customerName = _customerName;
        this._id = _id;
        this._details = _details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersInquiries that = (CustomersInquiries) o;

        if (_id != null ? !_id.equals(that._id) : that._id != null) {
            return false;
        }

        return _details != null ? _details.equals(that._details) : that._details == null;

    }

    @Override
    public String toString() {
        return "CustomersInquiries{" +
                "_id='" + _id + '\'' +
                ", _details='" + _details + '\'' +
                "}\n\t";
    }
}
