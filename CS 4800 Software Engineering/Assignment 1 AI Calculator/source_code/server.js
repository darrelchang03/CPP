const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const OpenAI = require('openai');
require('dotenv').config();

const app = express();
app.use(bodyParser.json());
app.use(cors());


app.post('/api/chat', async (req, res) => {
    const openai = new OpenAI({ apiKey: process.env.OPEN_AI_KEY});
    const input = req.body.prompt;
    try {
        const response = await openai.chat.completions.create ({
            model: "gpt-3.5-turbo",
            messages: [     
                {role: "system", content: "You are a calculator that takes in math expression. Calculate the results and do not include explaination. Only include the calculated value."},
                { role: "user", content: input},
            ],
        });
        const responseContent = response.choices[0].message.content;
        res.json({ message: responseContent });
    }
    catch (error) {
        console.error("Error with API call:", error.message);
        res.status(500).json({ error: 'Error with the API Call '});
    }

});
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
})