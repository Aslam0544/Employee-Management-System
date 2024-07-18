import axios from 'axios';
const URL="http://localhost:9090/api/v1/employees";
class EmployeeService
{
    getEmployees()
    {
        return axios.get(URL)
    }
    createEmployee(employee)
    {
         return axios.post(URL,employee);   
    }
    getEmployeeById(employeeId)
    {
        return axios.get(URL+'/'+employeeId);
    }
    updateEmployee(employeeId,employee)
    {
        return axios.put(URL+'/'+employeeId,employee);
    }
    deleteEmployee(employeeId)
    {
          return axios.delete(URL+'/'+employeeId);  
    }
}
export default new EmployeeService();