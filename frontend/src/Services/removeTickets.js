export const removeTickets = async (id, ticket_count) => {
    try {
        const response = await fetch(`http://localhost:8080/api/customer/${id}/remove-tickets?ticket_count=${ticket_count}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.statusText}`);
        }

        const data = await response.text(); // Assuming the response is plain text 
        return data;
    } catch (error) {
        console.error('Error in removeTickets API:', error);
        throw error;
    }
};
