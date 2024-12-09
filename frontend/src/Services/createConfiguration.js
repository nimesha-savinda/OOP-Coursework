export const createConfiguration = async (configurationData) => {
    try {
        const response = await fetch('/api/config/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(configurationData),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw errorData.message || 'Failed to create configuration.';
        }

        return response.text(); // Assuming the backend returns a plain string as a response
    } catch (error) {
        console.error('Error in configuration API:', error);
        throw error;
    }
};