/* Homework 2 */
#include <stdio.h>
#include <openssl/bn.h>

# define NBITS 256

void printBN(char *msg, BIGNUM * a)
{
/* Use BN_bn2hex(a) for hex string
* Use BN_bn2dec(a) for decimal string */
char * number_str = BN_bn2hex(a);
printf("%s %s\n", msg, number_str);
OPENSSL_free(number_str);
}

int main() 
{
    // Task 1
    BN_CTX *ctx = BN_CTX_new();

    BIGNUM *p = BN_new();
    BIGNUM *q = BN_new();
    BIGNUM *e = BN_new();

    BIGNUM *phiN = BN_new();
    BIGNUM *d = BN_new();

    // Assignning variables to corrent values
    BN_hex2bn(&p, "F7E75FDC469067FFDC4E847C51F452DF");
    BN_hex2bn(&q, "E85CED54AF57E53E092113E62F436F4F");
    BN_hex2bn(&e, "0D88C3");

    // Calculate phi n = (p-1)(q-1)

    BIGNUM *p_minus_1 = BN_new();
    BIGNUM *q_minus_1 = BN_new();

    // First get values p-1 and q-1
    BN_sub(p_minus_1, p, BN_value_one());
    BN_sub(q_minus_1, q, BN_value_one());

    //Setting phi of N to be (p-1) * (q-1)
    BN_mul(phiN, p_minus_1, q_minus_1, ctx);

    // Calculate mod inverse of d = e mod phi
    BN_mod_inverse(d, e, phiN, ctx);

    // Printing results
    printBN("phi N = ", phiN);
    printBN("e = ", e);
    printBN("d = ", d);

    // Freeing memory used
    BN_free(p);
    BN_free(q);
    BN_free(e);
    BN_free(phiN);
    BN_free(d);
    BN_free(p_minus_1);
    BN_free(q_minus_1);
    BN_CTX_free(ctx);

    // Task 2
    BN_CTX *ctx = BN_CTX_new();

    BIGNUM *n = BN_new();
    BIGNUM *e = BN_new();
    BIGNUM *m = BN_new();
    BIGNUM *d = BN_new();
    BIGNUM *c = BN_new();



    BN_hex2bn(&n, "DCBFFE3E51F62E09CE7032E2677A78946A849DC4CDDE3A4D0CB81629242FB1A5");
    BN_hex2bn(&e, "010001");
    // Message "A top secret!" in hex is "4120746f702073656372657421"
    BN_hex2bn(&m, "4120746f702073656372657421");
    BN_hex2bn(&d, "74D806F9F3A62BAE331FFE3F0A68AFE35B3D2E4794148AACBC26AA381CD7D30D");

    // C = M^e mod n 
    BN_mod_exp(c, m, e, n, ctx);

    // Outputting C we calculated with the terms m, e, n used
    printBN("For m = ", m);
    printBN("e = ", e);
    printBN("and n = ", n);
    printBN("C = ", c);

    BN_mod_exp(c, c, d, n, ctx);

    // Checking if values after being decrypted again is the same as original
    printBN("C after it has been decrypted using d = ", c);

    // Freeing memory used
    BN_free(d);
    BN_free(e);
    BN_free(m);
    BN_free(n);
    BN_free(c);
    BN_CTX_free(ctx);
    // Task 3

    // n, e, d same as task 2
    BN_CTX *ctx = BN_CTX_new();

    BIGNUM *n = BN_new();
    BIGNUM *e = BN_new();
    BIGNUM *d = BN_new();

    // Same values as task 2
    BN_hex2bn(&n, "DCBFFE3E51F62E09CE7032E2677A78946A849DC4CDDE3A4D0CB81629242FB1A5");
    BN_hex2bn(&e, "010001");
    BN_hex2bn(&d, "74D806F9F3A62BAE331FFE3F0A68AFE35B3D2E4794148AACBC26AA381CD7D30D");

    BIGNUM *c = BN_new();
    BIGNUM *m = BN_new();
    BN_hex2bn(&c, "8C0F971DF2F3672B28811407E2DABBE1DA0FEBBBDFC7DCB67396567EA1E2493F");

    // decoding c using M = C^d mod n
    BN_mod_exp(m, c, d, n, ctx);

    // Outputing m we calculated using c, d, and n.
    printBN("C =", c);
    printBN("d =", d);
    printBN("n =", n);
    printBN("Decoded message =", m);

    // Free memory used
    BN_free(n);
    BN_free(e);
    BN_free(d);
    BN_free(c);
    BN_free(m);

    BN_CTX_free(ctx);

    // Task 4

    BN_CTX *ctx = BN_CTX_new();

    BIGNUM *n = BN_new();
    BIGNUM *e = BN_new();
    BIGNUM *d = BN_new();
    BIGNUM *s = BN_new();

    BN_hex2bn(&n, "DCBFFE3E51F62E09CE7032E2677A78946A849DC4CDDE3A4D0CB81629242FB1A5");
    BN_hex2bn(&e, "010001");
    BN_hex2bn(&d, "74D806F9F3A62BAE331FFE3F0A68AFE35B3D2E4794148AACBC26AA381CD7D30D");

    BIGNUM *m = BN_new();

    // "I owe you $2000." = 49206F776520796F752024323030302E
    BN_hex2bn(&m, "49206F776520796F752024323030302E");

    BN_mod_exp(s, m, d, n, ctx);
    printBN("The signature for 'I owe you $2000.' =", s);

    // Changing m = "I owe you $3000." = 49206F776520796F752024333030302E
    BN_hex2bn(&m, "49206F776520796F752024333030302E");
    BN_mod_exp(s, m, d, n, ctx);
    printBN("The signature for 'I owe you $3000.' =", s);
    
    // Freeing memory used
    BN_free(n);
    BN_free(e);
    BN_free(d);
    BN_free(m);

    BN_CTX_free(ctx);

   // Task 5
   /*
    m = Launch a missile.
    s = 643D6F34902D9C7EC90CB0B2BCA36C47FA37165C0005CAB026C0542CBDB6802F
    e = 010001 (this hex value equals to decimal 65537)
    n = AE1CD4DC432798D933779FBD46C6E1247F0CF1233595113AA51B450F18116115
   */

    BN_CTX *ctx = BN_CTX_new();

    BIGNUM *m = BN_new();
    BIGNUM *s = BN_new();
    BIGNUM *e = BN_new();
    BIGNUM *n = BN_new();
    BIGNUM *m_prime = BN_new();

    // "Launch a missile. in hex = 4C61756E63682061206D697373696C652E"
    BN_hex2bn(&m, "4C61756E63682061206D697373696C652E");
    BN_hex2bn(&s, "643D6F34902D9C7EC90CB0B2BCA36C47FA37165C0005CAB026C0542CBDB6802F");
    BN_hex2bn(&e, "010001");
    BN_hex2bn(&n, "AE1CD4DC432798D933779FBD46C6E1247F0CF1233595113AA51B450F18116115");
    
    BN_mod_exp(m_prime, s, e, n, ctx);

    // Outputing to see if original message m matches the signature after verification
    printBN("The original message in hex =", m);
    printBN("The the signature after verifying =", m_prime);

}