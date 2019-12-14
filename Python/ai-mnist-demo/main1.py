import matplotlib.pyplot as plt
from tensorflow.examples.tutorials import mnist

image = mnist.train.images[1].reshape(-1, 28)
plt.subplot(131)
plt.imshow(image)
plt.axis('off')
plt.subplot(132)
plt.imshow(image, cmap='gray')
plt.axis('off')
plt.subplot(133)
plt.imshow(image, cmap='gray_r')
plt.axis('off')
plt.show()