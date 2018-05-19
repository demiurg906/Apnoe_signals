package com.medical.signals.signalsapp.data


class DummyDataProvider(listeners: List<DataEventListener>, val initalData: Int = 0) : DataProvider() {
    companion object {
        private const val DELAY: Long = 1000
    }

    private val Time = listOf<Double>(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0, 31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0, 40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0, 51.0, 52.0, 53.0, 54.0, 55.0, 56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 62.0, 63.0, 64.0, 65.0, 66.0, 67.0, 68.0, 69.0, 70.0, 71.0, 72.0, 73.0, 74.0, 75.0, 76.0, 77.0, 78.0, 79.0, 80.0, 81.0, 82.0, 83.0, 84.0, 85.0, 86.0, 87.0, 88.0, 89.0, 90.0, 91.0, 92.0, 93.0, 94.0, 95.0, 96.0, 97.0, 98.0, 99.0, 100.0, 101.0, 102.0, 103.0, 104.0, 105.0, 106.0, 107.0, 108.0, 109.0, 110.0, 111.0, 112.0, 113.0, 114.0, 115.0, 116.0, 117.0, 118.0, 119.0, 120.0, 121.0, 122.0, 123.0, 124.0, 125.0, 126.0, 127.0, 128.0, 129.0, 130.0, 131.0, 132.0, 133.0, 134.0, 135.0, 136.0, 137.0, 138.0, 139.0, 140.0, 141.0, 142.0, 143.0, 144.0, 145.0, 146.0, 147.0, 148.0, 149.0, 150.0, 151.0, 152.0, 153.0, 154.0, 155.0, 156.0, 157.0, 158.0, 159.0, 160.0, 161.0, 162.0, 163.0, 164.0, 165.0, 166.0, 167.0, 168.0, 169.0, 170.0, 171.0, 172.0, 173.0, 174.0, 175.0, 176.0, 177.0, 178.0, 179.0, 180.0, 181.0, 182.0, 183.0, 184.0, 185.0, 186.0, 187.0, 188.0, 189.0, 190.0, 191.0, 192.0, 193.0, 194.0, 195.0, 196.0, 197.0, 198.0, 199.0, 200.0, 201.0, 202.0, 203.0, 204.0, 205.0, 206.0, 207.0, 208.0, 209.0, 210.0, 211.0, 212.0, 213.0, 214.0, 215.0, 216.0, 217.0, 218.0, 219.0, 220.0, 221.0, 222.0, 223.0, 224.0, 225.0, 226.0, 227.0, 228.0, 229.0, 230.0, 231.0, 232.0, 233.0, 234.0, 235.0, 236.0, 237.0, 238.0, 239.0, 240.0, 241.0, 242.0, 243.0, 244.0, 245.0, 246.0, 247.0, 248.0, 249.0, 250.0, 251.0, 252.0, 253.0, 254.0, 255.0, 256.0, 257.0, 258.0, 259.0, 260.0, 261.0, 262.0, 263.0, 264.0, 265.0, 266.0, 267.0, 268.0, 269.0, 270.0, 271.0, 272.0, 273.0, 274.0, 275.0, 276.0, 277.0, 278.0, 279.0, 280.0, 281.0, 282.0, 283.0, 284.0, 285.0, 286.0, 287.0, 288.0, 289.0, 290.0, 291.0, 292.0, 293.0, 294.0, 295.0, 296.0, 297.0, 298.0, 299.0, 300.0, 301.0, 302.0, 303.0, 304.0, 305.0, 306.0, 307.0, 308.0, 309.0, 310.0, 311.0, 312.0, 313.0, 314.0, 315.0, 316.0, 317.0, 318.0, 319.0, 320.0, 321.0, 322.0, 323.0, 324.0, 325.0, 326.0, 327.0, 328.0, 329.0, 330.0, 331.0, 332.0, 333.0, 334.0, 335.0, 336.0, 337.0, 338.0, 339.0, 340.0, 341.0, 342.0, 343.0, 344.0, 345.0, 346.0, 347.0, 348.0, 349.0, 350.0, 351.0, 352.0, 353.0, 354.0, 355.0, 356.0, 357.0, 358.0, 359.0, 360.0, 361.0, 362.0, 363.0, 364.0, 365.0, 366.0, 367.0, 368.0, 369.0, 370.0, 371.0, 372.0, 373.0, 374.0, 375.0, 376.0, 377.0, 378.0, 379.0, 380.0, 381.0, 382.0, 383.0, 384.0, 385.0, 386.0, 387.0, 388.0, 389.0, 390.0, 391.0, 392.0, 393.0, 394.0, 395.0, 396.0, 397.0, 398.0, 399.0, 400.0, 401.0, 402.0, 403.0, 404.0, 405.0, 406.0, 407.0, 408.0, 409.0, 410.0, 411.0, 412.0, 413.0, 414.0, 415.0, 416.0, 417.0, 418.0, 419.0, 420.0, 421.0, 422.0, 423.0, 424.0, 425.0, 426.0, 427.0, 428.0, 429.0, 430.0, 431.0, 432.0, 433.0, 434.0, 435.0, 436.0, 437.0, 438.0, 439.0, 440.0, 441.0, 442.0, 443.0, 444.0, 445.0, 446.0, 447.0, 448.0, 449.0, 450.0, 451.0, 452.0, 453.0, 454.0, 455.0, 456.0, 457.0, 458.0, 459.0, 460.0, 461.0, 462.0, 463.0, 464.0, 465.0, 466.0, 467.0, 468.0, 469.0, 470.0, 471.0, 472.0, 473.0, 474.0, 475.0, 476.0, 477.0, 478.0, 479.0, 480.0, 481.0, 482.0, 483.0, 484.0, 485.0, 486.0, 487.0, 488.0, 489.0, 490.0, 491.0, 492.0, 493.0, 494.0, 495.0, 496.0, 497.0, 498.0, 499.0)
    private val BP = listOf<Double>(123.6214, 122.4552, 121.2889, 120.1227, 118.6973, 117.9198, 116.4944, 115.9761, 114.9394, 113.9027, 112.8661, 112.3478, 111.959, 111.3111, 110.2744, 110.5336, 110.0153, 109.7561, 109.4969, 109.4969, 109.1082, 108.9786, 109.1082, 108.849, 108.7195, 108.7195, 108.5899, 108.4603, 107.6828, 107.6828, 107.2941, 106.7757, 105.9982, 105.2207, 104.0545, 103.4066, 102.3699, 100.9445, 99.90787, 99.00079, 97.57539, 96.66831, 95.76124, 95.11333, 94.20625, 93.42876, 92.91043, 92.3921, 91.61461, 91.09628, 91.22586, 90.70753, 90.83711, 90.57795, 90.44836, 90.83711, 90.1892, 90.9667, 91.09628, 91.35545, 91.22586, 91.87377, 92.13293, 92.3921, 92.3921, 92.78085, 92.78085, 93.04001, 93.04001, 93.04001, 93.16959, 93.16959, 93.16959, 92.65127, 92.78085, 92.65127, 92.26252, 92.26252, 92.00336, 91.61461, 91.48502, 91.22586, 90.83711, 90.57795, 90.31879, 90.31879, 89.80045, 89.41171, 88.7638, 88.50463, 88.11589, 87.72714, 87.33839, 87.33839, 86.82007, 86.17216, 86.04257, 85.91299, 85.26508, 84.61717, 84.61717, 84.48759, 83.83968, 83.58051, 83.45093, 83.19176, 82.9326, 82.67344, 82.28469, 82.02553, 81.76636, 81.50719, 81.24803, 80.98887, 80.47054, 80.60012, 80.21137, 80.08179, 79.69305, 79.69305, 79.56346, 78.91555, 78.91555, 78.52681, 78.39722, 78.00848, 77.8789, 77.8789, 77.49015, 77.36057, 77.1014, 77.1014, 76.71265, 76.58308, 76.19433, 75.93517, 76.06474, 75.54642, 75.28725, 75.41683, 74.89851, 75.02808, 74.50976, 74.50976, 74.50976, 73.99143, 74.12101, 74.2506, 74.2506, 73.60268, 73.86185, 73.60268, 73.34352, 72.95477, 73.21394, 72.95477, 72.95477, 72.56602, 72.43644, 72.43644, 72.43644, 72.43644, 72.0477, 72.0477, 71.91811, 71.78853, 71.39979, 71.52937, 70.88145, 71.52937, 71.01104, 71.01104, 70.88145, 70.62229, 70.36313, 70.62229, 70.88145, 70.88145, 71.39979, 72.17728, 72.82519, 73.99143, 76.58308, 78.65639, 80.85928, 83.71009, 86.82007, 89.80045, 92.26252, 95.63165, 98.87121, 101.3333, 104.3137, 107.5532, 109.8857, 112.3478, 115.1986, 117.1423, 119.4748, 120.7706, 122.7143, 123.4918, 124.2693, 124.6581, 125.1764, 124.9172, 124.7876, 124.1397, 123.8806, 122.7143, 121.4185, 121.1593, 119.086, 118.179, 116.7536, 115.4577, 114.0323, 112.9957, 111.6998, 110.5336, 109.3674, 108.7195, 107.6828, 106.9053, 106.2574, 106.1278, 105.3503, 104.7024, 104.4432, 104.1841, 104.0545, 103.5362, 103.5362, 103.277, 103.0178, 103.0178, 102.8883, 102.6291, 102.3699, 101.9812, 101.5924, 100.8149, 100.167, 99.6487, 98.61205, 97.57539, 96.7979, 95.89082, 94.98374, 93.68792, 93.29918, 92.3921, 91.87377, 91.35545, 90.31879, 90.1892, 89.80045, 89.15254, 89.02296, 89.02296, 88.63422, 88.89338, 88.50463, 89.02296, 89.02296, 89.28213, 89.15254, 89.80045, 89.54129, 90.05962, 90.31879, 90.9667, 90.9667, 91.09628, 91.48502, 91.74419, 91.61461, 91.61461, 91.74419, 91.61461, 91.74419, 91.61461, 91.61461, 91.22586, 91.35545, 90.83711, 90.83711, 90.44836, 90.05962, 89.93004, 89.54129, 89.28213, 88.7638, 88.50463, 88.11589, 87.59756, 87.20881, 86.94965, 86.69048, 85.91299, 85.65382, 85.1355, 85.1355, 84.48759, 84.358, 83.83968, 83.58051, 83.32135, 82.67344, 82.80302, 82.02553, 82.02553, 81.76636, 81.76636, 81.24803, 81.24803, 80.47054, 80.72971, 80.21137, 80.47054, 79.69305, 79.69305, 79.56346, 79.17472, 79.04514, 79.04514, 79.04514, 78.26764, 78.52681, 78.26764, 78.26764, 77.61973, 77.61973, 77.61973, 77.23099, 76.97182, 76.97182, 76.58308, 76.32391, 76.58308, 76.19433, 75.93517, 75.67599, 75.80558, 75.54642, 75.28725, 75.02808, 75.02808, 75.02808, 74.63934, 74.50976, 74.38017, 73.99143, 74.12101, 73.99143, 73.4731, 73.60268, 73.34352, 73.34352, 72.95477, 72.69561, 72.30686, 72.43644, 72.43644, 72.0477, 71.91811, 71.52937, 71.78853, 71.65895, 71.52937, 70.88145, 71.2702, 71.14063, 70.75188, 70.88145, 70.49271, 70.75188, 70.10397, 70.23354, 70.10397, 69.97438, 69.8448, 69.8448, 69.71522, 69.71522, 69.45605, 69.97438, 69.97438, 70.23354, 71.14063, 72.0477, 73.99143, 75.80558, 78.13806, 80.21137, 83.32135, 85.91299, 89.54129, 92.26252, 95.37249, 98.48246, 101.5924, 104.832, 107.6828, 110.7928, 113.514, 116.1056, 118.179, 120.641, 121.8073, 123.6214, 124.7876, 125.4356, 125.8243, 125.9539, 125.9539, 125.6947, 125.306, 124.7876, 124.0102, 122.5847, 121.6777, 120.641, 119.4748, 118.0494, 117.1423, 115.8465, 114.6802, 113.9027, 112.7365, 111.8294, 110.7928, 109.8857, 109.6265, 108.9786, 108.2011, 107.6828, 107.6828, 107.4236, 107.1645, 106.9053, 106.7757, 106.6461, 106.9053, 106.6461, 106.5166, 106.2574, 106.2574, 105.9982, 105.8686, 105.4799, 105.2207, 104.9616, 104.0545, 103.5362, 102.4995, 101.8516, 100.8149, 99.90787, 98.48246, 97.83455, 96.66831, 95.63165, 94.85416, 94.33583, 93.94709, 92.65127, 92.65127, 91.74419, 91.48502, 90.9667, 90.70753, 90.9667, 90.83711, 90.44836, 90.70753, 90.83711, 90.57795, 90.57795, 91.09628, 91.09628, 91.35545, 91.61461, 91.87377, 92.26252, 92.13293, 92.3921, 92.65127, 92.65127, 92.52168, 92.78085, 92.65127, 92.65127, 92.65127, 92.65127, 92.3921, 92.13293, 92.13293, 91.61461, 91.61461)
    private val ECG = listOf<Double>(0.132, 0.124, 0.12, 0.112, 0.106, 0.1, 0.104, 0.1, 0.1, 0.098, 0.102, 0.104, 0.1, 0.104, 0.104, 0.106, 0.11, 0.104, 0.11, 0.116, 0.114, 0.114, 0.114, 0.114, 0.118, 0.116, 0.12, 0.126, 0.12, 0.126, 0.126, 0.126, 0.126, 0.138, 0.13, 0.128, 0.134, 0.13, 0.13, 0.134, 0.136, 0.136, 0.136, 0.144, 0.14, 0.136, 0.14, 0.136, 0.14, 0.138, 0.14, 0.138, 0.144, 0.142, 0.138, 0.14, 0.148, 0.144, 0.144, 0.146, 0.148, 0.144, 0.144, 0.148, 0.142, 0.148, 0.148, 0.144, 0.142, 0.148, 0.148, 0.144, 0.15, 0.146, 0.144, 0.148, 0.152, 0.158, 0.16, 0.16, 0.162, 0.162, 0.168, 0.168, 0.166, 0.174, 0.18, 0.182, 0.184, 0.184, 0.19, 0.182, 0.184, 0.184, 0.184, 0.184, 0.182, 0.18, 0.176, 0.168, 0.164, 0.16, 0.162, 0.152, 0.15, 0.15, 0.146, 0.144, 0.14, 0.142, 0.136, 0.14, 0.14, 0.138, 0.138, 0.14, 0.138, 0.138, 0.142, 0.146, 0.144, 0.144, 0.146, 0.136, 0.12, 0.096, 0.084, 0.088, 0.118, 0.172, 0.288, 0.438, 0.592, 0.726, 0.834, 0.864, 0.7, 0.474, 0.258, 0.126, 0.08, 0.072, 0.08, 0.084, 0.086, 0.1, 0.108, 0.118, 0.116, 0.118, 0.116, 0.116, 0.12, 0.12, 0.12, 0.118, 0.124, 0.128, 0.128, 0.128, 0.134, 0.136, 0.136, 0.14, 0.14, 0.144, 0.144, 0.146, 0.148, 0.156, 0.154, 0.152, 0.154, 0.158, 0.16, 0.16, 0.16, 0.17, 0.17, 0.172, 0.176, 0.178, 0.184, 0.184, 0.186, 0.192, 0.194, 0.196, 0.198, 0.206, 0.206, 0.21, 0.21, 0.216, 0.214, 0.218, 0.22, 0.216, 0.216, 0.216, 0.214, 0.208, 0.208, 0.198, 0.186, 0.176, 0.168, 0.158, 0.152, 0.14, 0.13, 0.124, 0.116, 0.116, 0.108, 0.104, 0.106, 0.1, 0.102, 0.104, 0.104, 0.102, 0.104, 0.104, 0.104, 0.106, 0.112, 0.112, 0.114, 0.112, 0.114, 0.116, 0.114, 0.12, 0.12, 0.122, 0.124, 0.12, 0.12, 0.126, 0.128, 0.128, 0.126, 0.132, 0.132, 0.138, 0.134, 0.134, 0.136, 0.14, 0.136, 0.136, 0.144, 0.142, 0.138, 0.138, 0.144, 0.144, 0.14, 0.144, 0.144, 0.144, 0.146, 0.144, 0.144, 0.144, 0.144, 0.144, 0.144, 0.148, 0.146, 0.144, 0.144, 0.148, 0.144, 0.148, 0.148, 0.146, 0.146, 0.15, 0.146, 0.146, 0.146, 0.15, 0.148, 0.15, 0.152, 0.15, 0.152, 0.156, 0.16, 0.16, 0.164, 0.164, 0.166, 0.17, 0.176, 0.176, 0.184, 0.19, 0.188, 0.184, 0.182, 0.186, 0.182, 0.186, 0.186, 0.184, 0.178, 0.172, 0.17, 0.162, 0.16, 0.158, 0.158, 0.152, 0.148, 0.144, 0.142, 0.144, 0.14, 0.144, 0.136, 0.14, 0.14, 0.142, 0.138, 0.142, 0.138, 0.14, 0.14, 0.144, 0.146, 0.144, 0.136, 0.12, 0.108, 0.09, 0.088, 0.12, 0.184, 0.292, 0.44, 0.59, 0.73, 0.836, 0.888, 0.744, 0.516, 0.304, 0.14, 0.082, 0.08, 0.082, 0.082, 0.088, 0.106, 0.112, 0.112, 0.114, 0.112, 0.112, 0.112, 0.11, 0.112, 0.116, 0.12, 0.122, 0.12, 0.126, 0.128, 0.128, 0.134, 0.132, 0.136, 0.134, 0.14, 0.144, 0.142, 0.144, 0.144, 0.15, 0.152, 0.156, 0.156, 0.158, 0.162, 0.164, 0.164, 0.168, 0.172, 0.176, 0.176, 0.18, 0.184, 0.184, 0.19, 0.19, 0.196, 0.2, 0.2, 0.208, 0.204, 0.21, 0.214, 0.224, 0.218, 0.208, 0.208, 0.208, 0.208, 0.206, 0.2, 0.196, 0.192, 0.182, 0.176, 0.16, 0.15, 0.138, 0.13, 0.12, 0.112, 0.11, 0.1, 0.096, 0.094, 0.092, 0.092, 0.09, 0.096, 0.092, 0.094, 0.094, 0.09, 0.096, 0.1, 0.1, 0.098, 0.102, 0.102, 0.112, 0.112, 0.116, 0.12, 0.12, 0.12, 0.12, 0.124, 0.13, 0.126, 0.128, 0.128, 0.13, 0.128, 0.128, 0.134, 0.132, 0.136, 0.136, 0.136, 0.132, 0.136, 0.136, 0.138, 0.14, 0.142, 0.144, 0.142, 0.142, 0.142, 0.14, 0.144, 0.146, 0.144, 0.144, 0.144, 0.144, 0.144, 0.148, 0.144, 0.15, 0.148, 0.144, 0.144, 0.148, 0.152, 0.15, 0.144, 0.148, 0.152, 0.146, 0.146, 0.15, 0.152, 0.152, 0.148, 0.15, 0.152, 0.152)
    private val SO2 = listOf<Double>(91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.42857, 91.42857, 91.48052, 91.53247, 91.48052, 91.48052, 91.42857, 91.53247, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.42857, 91.37663, 91.42857, 91.42857, 91.42857, 91.42857, 91.48052, 91.53247, 91.53247, 91.53247, 91.53247, 91.53247, 91.53247, 91.53247, 91.42857, 91.53247, 91.53247, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.42857, 91.42857, 91.37663, 91.42857, 91.42857, 91.37663, 91.42857, 91.42857, 91.42857, 91.42857, 91.42857, 91.42857, 91.42857, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.42857, 91.53247, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.48052, 91.42857, 91.42857, 91.42857, 91.42857, 91.37663, 91.32468, 91.37663, 91.37663, 91.37663, 91.42857, 91.42857, 91.48052, 91.42857, 91.42857, 91.48052, 91.42857, 91.37663, 91.42857, 91.42857, 91.37663, 91.37663, 91.32468, 91.37663, 91.37663, 91.37663, 91.32468, 91.37663, 91.37663, 91.32468, 91.37663, 91.42857, 91.37663, 91.37663, 91.42857, 91.42857, 91.42857, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.32468, 91.42857, 91.48052, 91.37663, 91.42857, 91.37663, 91.42857, 91.42857, 91.42857, 91.42857, 91.48052, 91.53247, 91.42857, 91.37663, 91.42857, 91.42857, 91.37663, 91.37663, 91.42857, 91.42857, 91.32468, 91.37663, 91.37663, 91.37663, 91.37663, 91.32468, 91.42857, 91.37663, 91.42857, 91.37663, 91.42857, 91.42857, 91.37663, 91.42857, 91.42857, 91.42857, 91.42857, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.42857, 91.42857, 91.48052, 91.42857, 91.48052, 91.42857, 91.42857, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.42857, 91.42857, 91.48052, 91.42857, 91.42857, 91.32468, 91.42857, 91.42857, 91.32468, 91.37663, 91.37663, 91.37663, 91.32468, 91.32468, 91.37663, 91.37663, 91.32468, 91.37663, 91.37663, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.42857, 91.37663, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.42857, 91.42857, 91.48052, 91.42857, 91.42857, 91.48052, 91.42857, 91.48052, 91.48052, 91.42857, 91.48052, 91.53247, 91.53247, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.37663, 91.48052, 91.42857, 91.48052, 91.37663, 91.48052, 91.48052, 91.42857, 91.42857, 91.48052, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.37663, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.42857, 91.37663, 91.42857, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.48052, 91.42857, 91.48052, 91.37663, 91.48052, 91.37663, 91.37663, 91.37663, 91.42857, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.32468, 91.37663, 91.37663, 91.42857, 91.37663, 91.42857, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.37663, 91.37663, 91.48052, 91.48052, 91.42857, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.53247, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.37663, 91.48052, 91.42857, 91.42857, 91.37663, 91.48052, 91.42857, 91.42857, 91.37663, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.42857, 91.32468, 91.37663, 91.37663, 91.48052, 91.42857, 91.42857, 91.42857, 91.53247, 91.48052, 91.48052, 91.42857, 91.48052, 91.42857, 91.37663, 91.42857, 91.48052, 91.42857, 91.37663, 91.48052, 91.53247, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.48052, 91.42857, 91.53247, 91.48052, 91.42857, 91.42857, 91.48052, 91.42857, 91.42857, 91.37663, 91.37663, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.27273, 91.32468, 91.32468, 91.32468, 91.32468, 91.37663, 91.42857, 91.37663, 91.37663, 91.37663, 91.42857, 91.32468, 91.32468, 91.32468, 91.37663, 91.32468, 91.32468, 91.37663, 91.37663, 91.32468, 91.32468, 91.32468, 91.32468, 91.37663, 91.37663, 91.37663, 91.37663, 91.37663, 91.32468, 91.32468, 91.37663, 91.37663, 91.37663, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468, 91.37663, 91.42857, 91.37663, 91.32468, 91.37663, 91.37663, 91.37663, 91.37663, 91.27273, 91.32468, 91.32468, 91.32468, 91.32468, 91.37663, 91.32468, 91.32468, 91.37663, 91.37663, 91.42857, 91.32468, 91.37663, 91.37663, 91.37663, 91.32468, 91.42857, 91.37663, 91.37663, 91.37663, 91.32468, 91.37663, 91.37663, 91.37663, 91.32468, 91.32468, 91.32468, 91.32468, 91.32468)
    private val Rest1 = listOf<Double>(0.1844015, 0.1831923, 0.1862152, 0.1795647, 0.1886336, 0.1801693, 0.1868198, 0.1813785, 0.1825877, 0.1825877, 0.1783555, 0.1825877, 0.1741233, 0.1807739, 0.171705, 0.1765417, 0.171705, 0.171705, 0.171705, 0.1668682, 0.1741233, 0.1650544, 0.1741233, 0.1662636, 0.1692866, 0.1668682, 0.1644498, 0.1674728, 0.1620314, 0.1692866, 0.162636, 0.168682, 0.1644498, 0.1668682, 0.1668682, 0.1638452, 0.1680774, 0.1596131, 0.1650544, 0.1577993, 0.1620314, 0.1608223, 0.1614268, 0.1638452, 0.1596131, 0.1662636, 0.1559855, 0.1638452, 0.1559855, 0.1584039, 0.1559855, 0.1535671, 0.1553809, 0.1499395, 0.1541717, 0.1475212, 0.1523579, 0.1499395, 0.1505441, 0.1517533, 0.1487304, 0.1529625, 0.1469166, 0.1523579, 0.1451028, 0.1481258, 0.1451028, 0.1451028, 0.1481258, 0.1444982, 0.1499395, 0.1426844, 0.1499395, 0.143289, 0.1444982, 0.1420798, 0.140266, 0.1420798, 0.1378476, 0.1426844, 0.1384522, 0.1414752, 0.1390568, 0.140266, 0.140266, 0.1378476, 0.1426844, 0.1366384, 0.140266, 0.1348247, 0.1366384, 0.1342201, 0.1330109, 0.1360339, 0.1324063, 0.1378476, 0.1305925, 0.1348247, 0.1287787, 0.1293833, 0.1275695, 0.1251512, 0.1269649, 0.1233374, 0.1263603, 0.1233374, 0.1251512, 0.1245466, 0.1251512, 0.1257557, 0.1233374, 0.1257557, 0.120919, 0.123942, 0.120919, 0.1227328, 0.1197098, 0.1185006, 0.1191052, 0.1166868, 0.120919, 0.1160822, 0.1197098, 0.1142684, 0.114873, 0.1136639, 0.1112455, 0.1124547, 0.1094317, 0.1112455, 0.1082225, 0.1082225, 0.1088271, 0.1088271, 0.1100363, 0.1076179, 0.1088271, 0.1058041, 0.1051995, 0.1033857, 0.1033857, 0.1015719, 0.1015719, 0.1045949, 0.1027811, 0.1058041, 0.1021765, 0.1039903, 0.09975816, 0.1009673, 0.09975816, 0.09915357, 0.1009673, 0.09854897, 0.09975816, 0.09854897, 0.09915357, 0.09854897, 0.09733978, 0.09733978, 0.09431681, 0.09431681, 0.09189843, 0.09189843, 0.09129383, 0.09189843, 0.09129383, 0.09008464, 0.09068924, 0.08948005, 0.09189843, 0.09008464, 0.09189843, 0.08948005, 0.08887545, 0.08827086, 0.08766626, 0.08766626, 0.08706167, 0.08887545, 0.08948005, 0.09008464, 0.09189843, 0.09250302, 0.09371221, 0.09250302, 0.09250302, 0.09189843, 0.09189843, 0.09189843, 0.09431681, 0.0949214, 0.09613059, 0.09733978, 0.09673519, 0.09915357, 0.09613059, 0.09975816, 0.09794438, 0.09915357, 0.09915357, 0.09794438, 0.09915357, 0.09915357, 0.1015719, 0.1015719, 0.1015719, 0.1009673, 0.1009673, 0.1027811, 0.1027811, 0.1045949, 0.1021765, 0.1027811, 0.1009673, 0.1021765, 0.1021765, 0.1015719, 0.1045949, 0.1021765, 0.1051995, 0.1015719, 0.1033857, 0.1003628, 0.1003628, 0.09975816, 0.09915357, 0.1015719, 0.09975816, 0.1015719, 0.1009673, 0.1003628, 0.1009673, 0.1015719, 0.1033857, 0.1021765, 0.1051995, 0.1033857, 0.1058041, 0.1051995, 0.1064087, 0.1064087, 0.1064087, 0.1100363, 0.1082225, 0.1136639, 0.1112455, 0.1142684, 0.1112455, 0.1118501, 0.1124547, 0.1106409, 0.1136639, 0.1112455, 0.1136639, 0.1130593, 0.1130593, 0.1130593, 0.1124547, 0.1136639, 0.1112455, 0.1136639, 0.1106409, 0.1112455, 0.1100363, 0.1106409, 0.1100363, 0.1100363, 0.1118501, 0.1088271, 0.1130593, 0.1094317, 0.1136639, 0.1118501, 0.1130593, 0.1142684, 0.1124547, 0.1154776, 0.1136639, 0.1172914, 0.1154776, 0.1160822, 0.1172914, 0.1160822, 0.1185006, 0.1160822, 0.1185006, 0.1154776, 0.117896, 0.1160822, 0.1191052, 0.1203144, 0.1197098, 0.123942, 0.120919, 0.1287787, 0.1257557, 0.1287787, 0.1257557, 0.1251512, 0.1269649, 0.1251512, 0.1305925, 0.1275695, 0.1305925, 0.1281741, 0.1287787, 0.1287787, 0.1263603, 0.1293833, 0.1257557, 0.1287787, 0.1257557, 0.1281741, 0.1275695, 0.1293833, 0.1299879, 0.1281741, 0.1311971, 0.1257557, 0.1305925, 0.1263603, 0.1293833, 0.1263603, 0.1257557, 0.1269649, 0.123942, 0.1287787, 0.1257557, 0.1293833, 0.1275695, 0.1275695, 0.1281741, 0.1275695, 0.1305925, 0.1269649, 0.1305925, 0.1275695, 0.1293833, 0.1275695, 0.1281741, 0.1299879, 0.1281741, 0.1342201, 0.1305925, 0.1378476, 0.1336155, 0.1378476, 0.1354293, 0.1348247, 0.1366384, 0.1336155, 0.1378476, 0.1324063, 0.1354293, 0.1330109, 0.1348247, 0.1366384, 0.1354293, 0.1396614, 0.1354293, 0.1396614, 0.1360339, 0.1378476, 0.1354293, 0.1378476, 0.1378476, 0.1354293, 0.1426844, 0.1366384, 0.143289, 0.1378476, 0.140266, 0.137243, 0.1354293, 0.137243, 0.1342201, 0.1396614, 0.1360339, 0.1408706, 0.1384522, 0.1396614, 0.1414752, 0.1390568, 0.1426844, 0.1378476, 0.143289, 0.1396614, 0.140266, 0.1378476, 0.1378476, 0.1384522, 0.1360339, 0.1414752, 0.1354293, 0.1420798, 0.137243, 0.140266, 0.1384522, 0.1378476, 0.140266, 0.1378476, 0.143289, 0.1396614, 0.1451028, 0.1426844, 0.1438936, 0.1469166, 0.1451028, 0.1499395, 0.1451028, 0.1517533, 0.1475212, 0.1511487, 0.1499395, 0.1505441, 0.1529625, 0.1499395, 0.1571947, 0.1499395, 0.1590085, 0.1529625, 0.1577993, 0.1571947, 0.1565901, 0.1614268, 0.1553809, 0.1620314, 0.1553809, 0.1614268, 0.1577993, 0.1590085, 0.1602176, 0.1559855, 0.1602176, 0.1547763, 0.1602176, 0.1547763, 0.1577993, 0.1547763, 0.1547763, 0.1577993, 0.1547763, 0.1644498, 0.1571947, 0.1650544, 0.1596131, 0.1620314, 0.1596131, 0.1565901, 0.1614268, 0.1553809, 0.1620314, 0.1565901, 0.1614268, 0.1577993, 0.1584039, 0.1602176, 0.1571947, 0.1644498, 0.1577993, 0.165659, 0.1602176, 0.1632406, 0.1620314, 0.1620314, 0.1644498, 0.1596131, 0.1674728, 0.1590085, 0.1662636, 0.1602176, 0.1632406, 0.162636, 0.1596131, 0.1632406, 0.1577993, 0.1644498, 0.1590085, 0.1632406, 0.1602176, 0.1602176, 0.1632406, 0.1596131, 0.1644498, 0.1571947, 0.1632406, 0.1577993, 0.1608223, 0.1602176, 0.1590085, 0.1638452, 0.1571947, 0.165659, 0.1584039, 0.1644498, 0.1596131, 0.1614268, 0.1608223, 0.1584039)
    private val Rest2 = listOf<Double>(0.08108108, 0.08108108, 0.08108108, 0.08108108, 0.08108108, 0.08108108, 0.07985258, 0.07923833, 0.07985258, 0.07923833, 0.07862408, 0.07862408, 0.07862408, 0.07739558, 0.07616708, 0.07555283, 0.07555283, 0.07432432, 0.07555283, 0.07493857, 0.07371007, 0.07371007, 0.07371007, 0.07309582, 0.07248157, 0.07186732, 0.07248157, 0.07186732, 0.07125307, 0.07125307, 0.07002457, 0.07002457, 0.06879607, 0.06941032, 0.06879607, 0.06879607, 0.06818182, 0.06695332, 0.06695332, 0.06633907, 0.06633907, 0.06572482, 0.06572482, 0.06511057, 0.06388206, 0.06449631, 0.06388206, 0.06449631, 0.06388206, 0.06388206, 0.06388206, 0.06388206, 0.06326781, 0.06326781, 0.06326781, 0.06326781, 0.06265356, 0.06265356, 0.06265356, 0.06265356, 0.06203931, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06265356, 0.06203931, 0.06203931, 0.06203931, 0.06203931, 0.06142506, 0.06142506, 0.06203931, 0.06203931, 0.06203931, 0.06326781, 0.06203931, 0.06265356, 0.06203931, 0.06142506, 0.06142506, 0.06203931, 0.06203931, 0.06265356, 0.06265356, 0.06203931, 0.06203931, 0.06142506, 0.06203931, 0.06265356, 0.06265356, 0.06203931, 0.06265356, 0.06265356, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06203931, 0.06081081, 0.06081081, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06203931, 0.06142506, 0.06203931, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06142506, 0.06203931, 0.06326781, 0.06326781, 0.06326781, 0.06388206, 0.06388206, 0.06388206, 0.06388206, 0.06388206, 0.06388206, 0.06326781, 0.06326781, 0.06388206, 0.06388206, 0.06326781, 0.06388206, 0.06388206, 0.06388206, 0.06388206, 0.06449631, 0.06633907, 0.06572482, 0.06633907, 0.06572482, 0.06511057, 0.06449631, 0.06511057, 0.06449631, 0.06511057, 0.06511057, 0.06511057, 0.06572482, 0.06511057, 0.06572482, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06633907, 0.06695332, 0.06633907, 0.06695332, 0.06756757, 0.06695332, 0.06818182, 0.06879607, 0.06879607, 0.06879607, 0.06879607, 0.06879607, 0.06818182, 0.06818182, 0.06756757, 0.06818182, 0.06818182, 0.06879607, 0.07063882, 0.07248157, 0.07186732, 0.07371007, 0.07371007, 0.07493857, 0.07493857, 0.07555283, 0.07555283, 0.07555283, 0.07493857, 0.07616708, 0.07555283, 0.07616708, 0.07616708, 0.07616708, 0.07678133, 0.07678133, 0.07678133, 0.07739558, 0.07800983, 0.07862408, 0.07862408, 0.07862408, 0.07923833, 0.07923833, 0.07985258, 0.08046683, 0.08046683, 0.08169533, 0.08230958, 0.08353808, 0.08415233, 0.08476658, 0.08476658, 0.08476658, 0.08538084, 0.08599509, 0.08660934, 0.08722359, 0.08845209, 0.08845209, 0.08906634, 0.08968059, 0.09090909, 0.09029484, 0.09090909, 0.09090909, 0.09090909, 0.09213759, 0.09275184, 0.09336609, 0.09336609, 0.09336609, 0.09336609, 0.09398034, 0.09398034, 0.09398034, 0.09459459, 0.09643735, 0.0958231, 0.0970516, 0.0982801, 0.0982801, 0.0982801, 0.0982801, 0.0995086, 0.09889435, 0.09889435, 0.0982801, 0.09889435, 0.0982801, 0.0995086, 0.1001228, 0.1007371, 0.1007371, 0.1013514, 0.1025798, 0.1031941, 0.1056511, 0.1056511, 0.1068796, 0.1074939, 0.1074939, 0.1081081, 0.1081081, 0.1081081, 0.1087224, 0.1099509, 0.1099509, 0.1105651, 0.1111794, 0.1124079, 0.1130221, 0.1124079, 0.1117936, 0.1117936, 0.1130221, 0.1124079, 0.1130221, 0.1142506, 0.1154791, 0.1154791, 0.1154791, 0.1154791, 0.1179361, 0.1185504, 0.1197789, 0.1216216, 0.1228501, 0.1228501, 0.1240786, 0.1234644, 0.1246929, 0.1246929, 0.1253071, 0.1265356, 0.1271499, 0.1283784, 0.1289926, 0.1302211, 0.1320639, 0.1326781, 0.1339066, 0.1345209, 0.1345209, 0.1351351, 0.1351351, 0.1363636, 0.1375921, 0.1382064, 0.1394349, 0.1406634, 0.1400491, 0.1406634, 0.1400491, 0.1400491, 0.1400491, 0.1400491, 0.1400491, 0.1400491, 0.1406634, 0.1406634, 0.1418919, 0.1406634, 0.1412776, 0.1412776, 0.1418919, 0.1418919, 0.1418919, 0.1425061, 0.1425061, 0.1425061, 0.1431204, 0.1443489, 0.1455774, 0.1468059, 0.1474202, 0.1474202, 0.1486486, 0.1474202, 0.1480344, 0.1474202, 0.1474202, 0.1474202, 0.1486486, 0.1498771, 0.1498771, 0.1504914, 0.1511057, 0.1511057, 0.1511057, 0.1517199, 0.1523342, 0.1535627, 0.1529484, 0.1547911, 0.1541769, 0.1541769, 0.1547911, 0.1547911, 0.1554054, 0.1547911, 0.1547911, 0.1535627, 0.1523342, 0.1523342, 0.1523342, 0.1523342, 0.1523342, 0.1523342, 0.1523342, 0.1523342, 0.1529484, 0.1535627, 0.1541769, 0.1535627, 0.1541769, 0.1541769, 0.1541769, 0.1541769, 0.1541769, 0.1547911, 0.1554054, 0.1547911, 0.1547911, 0.1554054, 0.1560197, 0.1566339, 0.1578624, 0.1578624, 0.1578624, 0.1578624, 0.1572482, 0.1560197, 0.1560197, 0.1547911, 0.1547911, 0.1547911, 0.1554054, 0.1554054, 0.1560197, 0.1572482, 0.1572482, 0.1597052, 0.1597052, 0.1609337, 0.1615479, 0.1621622, 0.1627764, 0.1627764, 0.1627764, 0.1615479, 0.1609337, 0.1603194, 0.1597052, 0.1590909, 0.1584767, 0.1572482, 0.1566339, 0.1560197, 0.1560197, 0.1547911, 0.1547911, 0.1529484, 0.1523342, 0.1504914, 0.1492629, 0.1474202, 0.1468059, 0.1461917, 0.1449631, 0.1443489, 0.1437346, 0.1425061, 0.1418919, 0.1412776, 0.1400491, 0.1388206, 0.1375921, 0.1363636, 0.1369779, 0.1363636, 0.1363636, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1369779, 0.1369779, 0.1375921, 0.1375921, 0.1363636, 0.1357494, 0.1363636, 0.1357494, 0.1363636, 0.1363636, 0.1363636, 0.1363636, 0.1363636, 0.1357494, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1351351, 0.1357494, 0.1369779, 0.1375921, 0.1382064, 0.1375921, 0.1375921, 0.1375921, 0.1382064, 0.1375921, 0.1382064, 0.1382064, 0.1382064, 0.1375921, 0.1375921, 0.1375921, 0.1382064, 0.1382064, 0.1388206, 0.1375921, 0.1369779, 0.1375921, 0.1363636, 0.1369779, 0.1369779, 0.1369779, 0.1363636, 0.1357494)

    private val serverThread: Thread

    init {
        listeners.forEach { addNewDataEventListener(it) }
        serverThread = Thread( {
            for (i in initalData until Time.size) {
                Thread.sleep(DELAY)
                val time = Time[i]
                fireEvent(DataPackage(time, BP[i], SensorType.BP))
                fireEvent(DataPackage(time, ECG[i], SensorType.ECG))
                fireEvent(DataPackage(time, SO2[i], SensorType.SO2))
                fireEvent(DataPackage(time, Rest1[i], SensorType.Rest1))
                fireEvent(DataPackage(time, Rest2[i], SensorType.Rest2))
            }
        } )
    }

    constructor(listener: DataEventListener, initialData: Int = 0) : this(listOf(listener), initialData)

    override fun getInitialSignals(): Map<SensorType, List<DataPackage>> {
        val res = mutableMapOf<SensorType, MutableList<DataPackage>>(
                Pair(SensorType.BP, mutableListOf<DataPackage>()),
                Pair(SensorType.ECG, mutableListOf<DataPackage>()),
                Pair(SensorType.SO2, mutableListOf<DataPackage>()),
                Pair(SensorType.Rest1, mutableListOf<DataPackage>()),
                Pair(SensorType.Rest2, mutableListOf<DataPackage>())
        )
        for (i in 0 until initalData) {
            val time = Time[i]
            res[SensorType.BP]?.add(DataPackage(time, BP[i], SensorType.BP))
            res[SensorType.ECG]?.add(DataPackage(time, ECG[i], SensorType.ECG))
            res[SensorType.SO2]?.add(DataPackage(time, SO2[i], SensorType.SO2))
            res[SensorType.Rest1]?.add(DataPackage(time, Rest1[i], SensorType.Rest1))
            res[SensorType.Rest2]?.add(DataPackage(time, Rest2[i], SensorType.Rest2))
        }

        if (!serverThread.isAlive) {
            serverThread.start()
        }
        return res
    }


}