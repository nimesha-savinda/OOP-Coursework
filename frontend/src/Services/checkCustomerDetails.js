export const checkCustomerDetails = async (username) => {
    try {
        const response = await fetch(`http://localhost:8080/api/customer/login/check/${username}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.statusText}`);
        }

        const data = await response.json(); // Assuming the backend returns a JSON object
        console.log(data)
        return data;
    } catch (error) {
        console.error('Error checking customer details:', error);
        throw error;
    }
};
