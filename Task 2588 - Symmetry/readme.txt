Farmer John, who likes symmetry, is now busy placing his cows on a field of size n x m.
To preserve symmetry, Farmer John arranges the cows in the following order. He puts a cow in the middle of the field. If there is no such square, then it just stops. Then he splits the field into four smaller fields of equal size (separated by rows and columns with a cow in the center) and places the cows on each of these areas according to the described algorithm. John continues dividing smaller fields until it can be done, or while the field has a central cell.
Consider an example. If n = 7 and m = 15, then farmer John places a cow in row 4 and column 8 and divides the field into four 3 x 7 fields. In each of the 3 x 7 fields, Farmer John has a cow in row 2 and column 4, and again divides each one into four 1 x 3 fields. 21 cow required for specified layout. If for example n = m = 5, then a single cow is enough for Farmer John, since after separation the 2 x 2 field will not have a central cell. Help Farmer John determine the number of cows needed to be placed on the field in the manner described.
Input data:
Two numbers n and m (1 ? n ? 10^9, 1 ? m ? 10^9).

Output:
Display the required number of cows.