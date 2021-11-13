#!/usr/bin/env python
# coding: utf-8

# # 回归问题

# ## 加载数据 波士顿房价

# In[12]:


from keras.datasets import boston_housing

(train_data, train_targets), (test_data, test_targets)=boston_housing.load_data()


# ## 数据标准化

# In[13]:


mean=train_data.mean(axis=0)
train_data -=mean
std=train_data.std(axis=0)
train_data/=std

test_data -=mean
test_data /=std


# In[14]:


train_data.shape


# ## 模型定义

# In[15]:


from keras import models
from keras import layers

def build_model():
    model=models.Sequential()
    model.add(layers.Dense(64,activation='relu',
                         input_shape=(train_data.shape[1],)))
    model.add(layers.Dense(64,activation='relu'))
    model.add(layers.Dense(1))
    model.compile(optimizer='rmsprop',loss='mse',metrics=['mae'])
    return model


# ## k折验证
# 当数据比较小的时候，用k折交叉验证，这种方法将可用数据划分为K个分区（K取4或5）

# In[28]:


import numpy as np

k=4
num_val_samples=len(train_data)//k
num_epochs=100
all_mae_histories=[]

model=build_model()

for i in range(k):
    print('processing fold #',i)
    val_data=train_data[i*num_val_samples:(i+1)*num_val_samples]
    val_targets=train_targets[i*num_val_samples:(i+1)*num_val_samples]
    
    partial_train_data=np.concatenate(
    [train_data[:i*num_val_samples],
    train_data[(i+1)*num_val_samples:]],
    axis=0)
    partial_train_targets=np.concatenate(
    [train_targets[:i*num_val_samples],
     train_targets[(i+1)*num_val_samples:]],
    axis=0)
    
    
    history=model.fit(partial_train_data,partial_train_targets,
                      validation_data=(val_data,val_targets),
                      epochs=num_epochs, batch_size=1, verbose=0)
    mae_histories=history.history['val_mae']
    all_mae_histories.append(mae_histories)


# In[29]:


average_mae_history=[np.mean([x[i] for x in all_mae_histories]) 
                     for i in range(num_epochs)]


import matplotlib.pyplot as plt

plt.plot(average_mae_history)
plt.xlabel('Epochs')
plt.ylabel('Valication MAE')
plt.show


# In[32]:


def smooth_curve(points,factor=0.9):
    smoothed_points=[]
    for point in points:
        if smoothed_points:
            previous=smoothed_points[-1]
            smoothed_points.append(previous*factor+point*(1-factor))
        else:
            smoothed_points.append(point)
    return smoothed_points
    
smooth_mae_history=smooth_curve(average_mae_history[:])
    
#plt.clf()
plt.plot(range(1,len(smooth_mae_history)+1),smooth_mae_history)
plt.xlabel('Epochs')
plt.ylabel('Valication MAE')
plt.show


# In[31]:


all_mae_histories


# In[ ]:




