package cn.anondata.encryption.crypto.hash;

/**
 * 手动实现的md5算法，主要有三个大的阶段步骤
 * 1. 将传进来的字符串进行对齐，使得长度为512bits的倍数，并且最后64bits要填写传进来的字符串的长度
 * 2. 将字符串进行分割，成为多个512bits（16个整型数字）的组，每个组进行遍历，实现四次循环
 * 3. 将结果以十六进制的形式返回字符串
 */
public class MD5Archive {

        private static final int A = 0x67452301;
        private static final int B = 0xefcdab89;
        private static final int C = 0x98badcfe;
        private static final int D = 0x10325476;

        private static final int SHIFT[][] = {
                        { 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22 },
                        { 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20 },
                        { 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23 },
                        { 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21 }
        };

        private static final int CONSTANT[][] = {
                        { 0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee, 0xf57c0faf, 0x4787c62a, 0xa8304613,
                                        0xfd469501,
                                        0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be, 0x6b901122, 0xfd987193,
                                        0xa679438e, 0x49b40821 },
                        { 0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa, 0xd62f105d, 0x02441453, 0xd8a1e681,
                                        0xe7d3fbc8,
                                        0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed, 0xa9e3e905, 0xfcefa3f8,
                                        0x676f02d9, 0x8d2a4c8a },
                        { 0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c, 0xa4beea44, 0x4bdecfa9, 0xf6bb4b60,
                                        0xbebfbc70,
                                        0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05, 0xd9d4d039, 0xe6db99e5,
                                        0x1fa27cf8, 0xc4ac5665 },
                        { 0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039, 0x655b59c3, 0x8f0ccc92, 0xffeff47d,
                                        0x85845dd1,
                                        0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1, 0xf7537e82, 0xbd3af235,
                                        0x2ad7d2bb, 0xeb86d391 }
        };

        private int[] result = { A, B, C, D };

        public String digest(String str) {
                // 1. 首先计算并修改长度
                byte[] strBytes = str.getBytes();
                byte[] paddingBytes;
                int len = strBytes.length;
                int groupCnt = len % 64;
                int remain = len / 64;
                if (remain <= 56) {
                        paddingBytes = new byte[(groupCnt + 1) * 64];
                        System.arraycopy(strBytes, 0, paddingBytes, 0, len);
                        boolean isFirst = true;
                        while (remain++ < 56) {
                                if (isFirst) {
                                        paddingBytes[len++] = 0b01000000;
                                        isFirst = false;
                                } else {
                                        paddingBytes[len++] = 0b00000000;
                                }
                        }
                        paddingBytes[len++] = 0b00000000;
                        paddingBytes[len++] = 0b00000000;
                        paddingBytes[len++] = 0b00000000;
                        paddingBytes[len++] = 0b00000000;
                        paddingBytes[len++] = (byte) (len >>> 24);
                        paddingBytes[len++] = (byte) (len >>> 16 & 0x000000ff);
                        paddingBytes[len++] = (byte) (len >>> 8 & 0x000000ff);
                        paddingBytes[len++] = (byte) (len & 0x000000ff);
                }

                // 2. 然后对修改长度后的字符数组进行FGHI计算
                groupCnt++;
                for (int i = 0; i < groupCnt; i++) {
                        int a = result[0], b = result[1], c = result[2], d = result[3];
                        a = FF(a, b, c, d, 1, SHIFT[0][0], CONSTANT[0][0]);
                        a = GG(a, b, c, d, 1, SHIFT[0][0], CONSTANT[0][0]);
                        a = HH(a, b, c, d, 1, SHIFT[0][0], CONSTANT[0][0]);
                        a = II(a, b, c, d, 1, SHIFT[0][0], CONSTANT[0][0]);
                }

                return "";
        }

        private static int F(int x, int y, int z) {
                return (x & y) | ((~x) & z);
        }

        private static int G(int x, int y, int z) {
                return (x & z) | (y & (~z));
        }

        private static int H(int x, int y, int z) {
                return x ^ y ^ z;
        }

        private static int I(int x, int y, int z) {
                return y ^ (x | (~z));
        }

        private static int FF(int a, int b, int c, int d, int i, int j, int k) {
                return b + (a + F(b, c, d) + i + j) << k;
        }

        private static int GG(int a, int b, int c, int d, int i, int j, int k) {
                return b + (a + G(b, c, d) + i + j) << k;
        }

        private static int HH(int a, int b, int c, int d, int i, int j, int k) {
                return b + (a + H(b, c, d) + i + j) << k;
        }

        private static int II(int a, int b, int c, int d, int i, int j, int k) {
                return b + (a + I(b, c, d) + i + j) << k;
        }
}
