class ProductOfNumbers {
public:
vector<int>prefixProd;
    ProductOfNumbers() {
        
    }
    
    void add(int num) {
        if(num == 0){
            prefixProd.clear();
        }
        else if(prefixProd.empty()){
            prefixProd.push_back(num);

        }else{
            int val = prefixProd.back();
            int newVal = val * num;
            prefixProd.push_back(newVal);
        }
        
    }
    
    int getProduct(int k) {
        if(k > prefixProd.size()) return 0;
        int productTillNow = prefixProd.back();
        int size = prefixProd.size();

        int idx = size - k;
        if(idx - 1 >= 0 && prefixProd[idx-1] != 0){
            return (productTillNow / prefixProd[idx-1]);
        }

        return productTillNow;
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */