#importing packages
import numpy as np
from scipy.sparse import csr_matrix
import matplotlib as mpl
mpl.use('TkAgg')
import matplotlib.pyplot as plt
from matplotlib.collections import LineCollection
from scipy.sparse.csgraph import dijkstra
import time as time
from scipy.spatial import cKDTree
from scipy.spatial.distance import pdist
from scipy.spatial.distance import squareform
from typing import Union




#Assigning constant parameters
FILE_NAME= 'GermanyCities.txt'
RADIUS = 0.0025
START_CITY_INDEX = 1573
END_CITY_INDEX = 10584


#Defining functions
def read_coordinate_files(filename:Union[str]):
    """
        Reads coordinates from the given file and converts the coordinates in the file to array of coordinates
        Parameters:
        -----------
        :param filename: The name of the file

        Returns:
        --------
        :return coordinate: The array of coordinates
        """
    with open(filename,'r') as file:
        c = []
        R = 1.0
        for line in file:
            data_split = line.split(',')
            #Calculating the coordinates based on the given equations
            xI = R * float((data_split[1].rstrip('}\n')))*np.pi/180.0
            yI = R * np.log(np.tan((np.pi/4.0)+(np.pi*float((data_split[0].strip('{')))/360.0)))
            c.append((xI, yI))
        coordinate = np.array(c)
    return coordinate


def plot_points(coord_list:Union[np.ndarray],indices:Union[np.ndarray],path:Union[np.ndarray]):
    """
            Plot data point
            Parameters:
            -----------
            :param coord_list: numpy array of the coordinates
            :param indices: indices of neighboring cities
            :param path: the shortest path between two given cities

            Returns:
            --------
            :return none
            """
    t_before_plotting = time.time()
    lines = []
    cheapest_path = []
    #Creating lines from the connections between neighboring cities
    for i, indexI in enumerate(indices):
        city1_index = indexI[0]
        city2_index = indexI[1]
        line = [coord_list[city1_index],coord_list[city2_index]]
        lines.append(line)

    #Creating path line from the connections between neighboring cities
    for i in range(len(path)-1):
        city1_index = path[i]
        city2_index = path[i+1]
        line = [coord_list[city1_index], coord_list[city2_index]]
        cheapest_path.append(line)

    line_segments = LineCollection(lines,linestyle='solid',linewidths=0.5,colors=['#808080'])
    line_segments_path = LineCollection(cheapest_path,linestyles='solid',linewidths=3, colors=['b'])
    fig = plt.figure()
    ax = fig.gca()
    Cities=plt.scatter(coord_list[:,0],coord_list[:,1], c=['r'],s=10)
    ax.add_collection(line_segments)
    ax.add_collection(line_segments_path)
    ax.legend([line_segments, line_segments_path], ["Path between two neighboring cities", "Shortest path"])
    ax.autoscale()
    t_after_plotting_wOut_pltShow = time.time()
    print("time in plot_points:", t_after_plotting_wOut_pltShow-t_before_plotting)
    plt.show()

def construct_graph_connections(coord_list:Union[np.array],radius:Union[float]):
    """
               computes all coordinates between all the points in coord_list that are in the given radius
               Parameters:
               -----------
               :param coord_list: numpy array of the coordinates
               :param radius: the given radius

               Returns:
               --------
               :return neighbouring_cities_np: indices of the neighboring cities
               :return cost_np: the costs to travel between two neighboring cities
               """
    neighbouring_cities = []
    cost = []

    #Calculating the distance between cities using pdist function
    distance_condensed_form = pdist(coord_list)

    #Converting the output of pdist into a square form
    distance_square_form = squareform(distance_condensed_form)

    #Finding neighboring cites by checking if their distance is less than given radius
    for city1_number,city1_coord in enumerate(coord_list):
        for city2_number, city2_coord in enumerate(coord_list):
            distance = distance_square_form[city1_number,city2_number]
            if (distance <= radius):
                neighbouring_cities.append([city1_number,city2_number])
                cost.append(distance**(9.0/10.0))

    neighbouring_cities_np = np.array(neighbouring_cities)
    cost_np = np.array(cost)
    return neighbouring_cities_np , cost_np

def construct_graph(indices:Union[np.array],costs:Union[np.array],N:Union[int]):
    """
                  constructs the compressed sparse graph from the indices of neighboring cities and the cost of
                  traveling between the neighboring cities
                  Parameters:
                  -----------
                  :param indices: the indices of neighboring cities
                  :param costs: the costs to travel between two neighboring cities
                  :param N: number of the cities in the file

                  Returns:
                  --------
                  :return csr_matrix: a compressed sparse row matrix of the costs of traveling between neighboring cities
                  """

    M=N
    return csr_matrix((costs,(indices[:,0],indices[:,1])),shape=(M,N))

def compute_path(predecessor_matrix,start_node,end_node):
    route_node = end_node
    path = [end_node]
    while (route_node != start_node ):
        route_node=predecessor_matrix[route_node]
        if(route_node != start_node):
            path.append(route_node)
    path.append(start_node)
    path = np.flip(path,0)
    return path

def construct_fast_graph_connections(coord_list, radius):
    nearby_cities = cKDTree(coord_list).query_ball_point(coord_list,radius)
    neighbouring_cities = []
    cost = []
    for cityI, nearby_cities_cityI in enumerate(nearby_cities):
        for nearby_city in nearby_cities_cityI:
            neighbouring_cities.append((cityI,nearby_city))
            city1_coord = coord_list[cityI]
            city2_coord = coord_list[nearby_city]
            distance = np.sqrt(((city1_coord[0]-city2_coord[0])**2.0)+((city1_coord[1]-city2_coord[1])**2.0))
            cost.append(distance ** (9.0 / 10.0))
    neighbouring_cities_np = np.array(neighbouring_cities)
    cost_np = np.array(cost)
    return neighbouring_cities_np,cost_np




#Main body of the code

#Reading the given coordinate file and saving the results into an array of coordinates called coordinates
t_start = time.time()
coordinates = read_coordinate_files(FILE_NAME)
t_after_read_coordinate_files = time.time()
print("Computational time in read_coordinate_file:" ,t_after_read_coordinate_files-t_start)

#Computing all the connections between all the points in coordinates array that are within RADIUS
indices , costs = construct_graph_connections(coordinates,RADIUS)
t_after_construct_graph_connections = time.time()
print("Computational time in construct_graph_connections:" ,t_after_construct_graph_connections-t_after_read_coordinate_files)

#Constructing a compressed sparse row matrix using csr_matrix​ in ​scipy.sparse​ package
csr_matrix_cities = construct_graph(indices,costs,len(coordinates))
t_after_construct_graph = time.time()
print("Computational time in construct_graph " ,t_after_construct_graph-t_after_construct_graph_connections)

#Finding the cheapest path through the graph using dijkstra function in scipy.sparse.csgraph
#dijkstra function uses the
#This function takes four parameters as input. In the following, these parameters are explained.
#1)csgraph: the compressed sparse matrix of the distances between the neighboring cities
#2)directed: When it is true, the alghorithm finds the path on directed path which means that the connection from i to j
#            are considered for calculating the shortest path. When it is false, both connections from i to j and j to i
#            are considered for calculating the shortest path.
#3)indices: This parameter specifies the starting point of the path.
#4)return_predecessors: When it is true, the function returns predecesor matrix which can be used to reconstruct the shortest paths
dist_matrix, predecessors = dijkstra(csgraph=csr_matrix_cities, directed=False, indices=START_CITY_INDEX, return_predecessors=True)

#Converting the data in predecessor matrix to a sequence of nodes that represent the cheapest path
path = compute_path(predecessors,START_CITY_INDEX,END_CITY_INDEX)
t_after_six_seven_tasks = time.time()
print("Computational time in 6 and 7 tasks " ,t_after_six_seven_tasks - t_after_construct_graph)

#Computing all the connections between all the points in ​coordinates that are within the radius given using cKDTree from
# SciPy package
indices2 , costs2 = construct_fast_graph_connections(coordinates,RADIUS)
t_after_construct_fast_graph_connections = time.time()
print("Computational time in construct_fast_graph_connections " ,t_after_construct_fast_graph_connections-t_after_six_seven_tasks)

#Printing the total computational time
print("Total computational time " ,t_after_construct_fast_graph_connections-t_start)

#Printing the total cost and the cheapest path
print('Total cost:', dist_matrix[END_CITY_INDEX])
print('The path:',path)

#Ploting all connections between the neighboring cities and the cheapest path
plot_points(coordinates,indices,path)
