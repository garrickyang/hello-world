k=4
num_val_samples=len(train_data)//k
num_epochs=10
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
    all_mae_histories=history.history['val_mae']
    all_mae_histories.append(val_mae)

import matplotlib.pyplot as plt

plt.plot(all_mae_histories)
plt.xlabel('Epochs')
plt.ylabel('Valication MAE')
plt.show

#average_mae_history=[np.mean([x[i] for x in all_mae_histories]) 
#                     for i in range(num_epochs)]


import matplotlib.pyplot as plt

plt.plot(all_mae_histories)
plt.xlabel('Epochs')
plt.ylabel('Valication MAE')
plt.show


def smooth_curve(points,factor=0.9):
    smoothed_points=[]
    for point in points:
        if smoothed_points:
            previous=smoothed_points[-1]
            smoothed_points.append(previous*factor+point*(1-factor))
        else:
            smoothed_points.append(point)
    return smoothed_points
    
smooth_mae_history=smooth_curve(all_mae_histories[10:])
    
plt.clf()
plt.plot(range(1,len(smooth_mae_history)+1),smooth_mae_history)
plt.xlabel('Epochs')
plt.ylabel('Valication MAE')
plt.show
